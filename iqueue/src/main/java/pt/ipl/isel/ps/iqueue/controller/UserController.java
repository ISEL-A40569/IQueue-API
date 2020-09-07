package pt.ipl.isel.ps.iqueue.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import pt.ipl.isel.ps.iqueue.dao.UserCredentialsDao;
import pt.ipl.isel.ps.iqueue.dao.UserDao;
import pt.ipl.isel.ps.iqueue.mapping.UserCredentialsDaoModelMapper;
import pt.ipl.isel.ps.iqueue.mapping.UserDaoModelMapper;
import pt.ipl.isel.ps.iqueue.model.User;
import pt.ipl.isel.ps.iqueue.model.UserCredentials;
import pt.ipl.isel.ps.iqueue.repository.*;
import pt.ipl.isel.ps.iqueue.utils.EmailService;
import pt.ipl.isel.ps.iqueue.utils.ErrorNotificationService;
import pt.ipl.isel.ps.iqueue.utils.PasswordGenerator;

import javax.transaction.Transactional;

@RestController
@RequestMapping("/api/iqueue/user")
public class UserController extends Controller<User, Integer, UserDao> {

    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private final UserDaoModelMapper userDaoModelMapper;

    @Autowired
    private final UserCredentialsRepository userCredentialsRepository;

    @Autowired
    private final AttendanceRepository attendanceRepository;

    @Autowired
    private final AttendanceClassificationRepository attendanceClassificationRepository;

    @Autowired
    private final AttendanceTicketRepository attendanceTicketRepository;

    @Autowired
    private final DeskUserRepository deskUserRepository;

    @Autowired
    private final OperatorUserRepository operatorUserRepository;

    @Autowired
    private final UserCredentialsDaoModelMapper userCredentialsDaoModelMapper;

    @Autowired
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private final PasswordGenerator passwordGenerator;

    @Autowired
    private final EmailService emailService;

    @Autowired
    private final ErrorNotificationService errorNotificationService;

    public UserController(UserRepository userRepository, UserDaoModelMapper userDaoModelMapper, UserCredentialsRepository userCredentialsRepository, AttendanceRepository attendanceRepository, AttendanceClassificationRepository attendanceClassificationRepository, AttendanceTicketRepository attendanceTicketRepository, DeskUserRepository deskUserRepository, OperatorUserRepository operatorUserRepository, UserCredentialsDaoModelMapper userCredentialsDaoModelMapper, BCryptPasswordEncoder bCryptPasswordEncoder, PasswordGenerator passwordGenerator, EmailService emailService, ErrorNotificationService errorNotificationService) {
        super(userRepository, userDaoModelMapper, errorNotificationService);
        this.userRepository = userRepository;
        this.userDaoModelMapper = userDaoModelMapper;
        this.userCredentialsRepository = userCredentialsRepository;
        this.attendanceRepository = attendanceRepository;
        this.attendanceClassificationRepository = attendanceClassificationRepository;
        this.attendanceTicketRepository = attendanceTicketRepository;
        this.deskUserRepository = deskUserRepository;
        this.operatorUserRepository = operatorUserRepository;
        this.userCredentialsDaoModelMapper = userCredentialsDaoModelMapper;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.passwordGenerator = passwordGenerator;
        this.emailService = emailService;
        this.errorNotificationService = errorNotificationService;
    }

    @GetMapping(value = "{userId}", headers = {"Accept=application/json"})
    public ResponseEntity getById(@PathVariable int userId) {
        return super.getById(userId);
    }

    @GetMapping(headers = {"Accept=application/json"})
    public ResponseEntity getAll() {
        return super.getAll();
    }

    @PostMapping(headers = {"Accept=application/json", "Content-Type=application/json"})
    public ResponseEntity add(@RequestBody User user) {
        try {
            User createdUser = userDaoModelMapper.mapDaoToModel(userRepository.save(userDaoModelMapper.
                    mapModelToDao(user)));

            String newPassword = passwordGenerator.generatePassword();

            UserCredentialsDao userCredentialsDao = new UserCredentialsDao(createdUser.getUserId(),
                    bCryptPasswordEncoder.encode(newPassword));
            userCredentialsRepository.save(userCredentialsDao);

            emailService.sendEmail(user.getEmail(),
                    "IQueue user registration",
                    buildRegistrationEmailMessage(createdUser.getUserId(), newPassword)
            );

            return super.add(createdUser,
                    "/api/iqueue/user/" + createdUser.getUserId());

        } catch (Exception exception) {
            errorNotificationService.sendErrorToAdministrators(exception.getMessage());
            return ResponseEntity.status(500).build();
        }
    }

    @DeleteMapping(value = "{userId}", headers = {"Accept=application/json"})
    @Transactional
    public ResponseEntity remove(@PathVariable Integer userId) {
        try {
            userCredentialsRepository.delete(userCredentialsRepository.findById(userId).get());
            operatorUserRepository.deleteByOperatorUserIdsUserId(userId);
            deskUserRepository.deleteByDeskUserIdsUserId(userId);

            attendanceRepository.findByClientId(userId).forEach(attendanceDao -> {
                attendanceTicketRepository.deleteByAttendanceId(attendanceDao.getAttendanceId());
                attendanceClassificationRepository.deleteByAttendanceId(attendanceDao.getAttendanceId());
            });

            attendanceRepository.deleteByClientId(userId);

            return super.remove(userId);
        } catch (Exception exception) {
            errorNotificationService.sendErrorToAdministrators(exception.getMessage());
            return ResponseEntity.status(500).build();
        }
    }

    @PutMapping(value = "{userId}", headers = {"Accept=application/json", "Content-Type=application/json"})
    public ResponseEntity update(@PathVariable Integer userId, @RequestBody User user) {
        user.setUserId(userId);
        return super.update(userId, user);
    }

    @PutMapping(value = "{userId}/credentials", headers = {"Accept=application/json"})
    public ResponseEntity changePassword(@PathVariable int userId, @RequestBody UserCredentials newUserCredentials) {
        try {
            newUserCredentials.setPassword(bCryptPasswordEncoder.encode(newUserCredentials.getPassword()));
            userCredentialsRepository.save(userCredentialsDaoModelMapper.mapModelToDao(newUserCredentials));
            return ResponseEntity.status(200).body(newUserCredentials);
        } catch (Exception exception) {
            errorNotificationService.sendErrorToAdministrators(exception.getMessage());
            return ResponseEntity.status(500).build();
        }
    }

    private String buildRegistrationEmailMessage(int userId, String password) {
        return "Welcome to IQueue!" + System.lineSeparator()
                + System.lineSeparator()
                + "User Id: " + userId
                + System.lineSeparator()
                + "Password: " + password;
    }
}
