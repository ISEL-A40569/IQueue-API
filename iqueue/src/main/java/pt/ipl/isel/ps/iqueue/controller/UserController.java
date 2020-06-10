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
import pt.ipl.isel.ps.iqueue.repository.UserCredentialsRepository;
import pt.ipl.isel.ps.iqueue.repository.UserRepository;
import pt.ipl.isel.ps.iqueue.utils.EmailService;
import pt.ipl.isel.ps.iqueue.utils.PasswordGenerator;

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
    private final UserCredentialsDaoModelMapper userCredentialsDaoModelMapper;

    @Autowired
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private final PasswordGenerator passwordGenerator;

    @Autowired
    private final EmailService emailService;

    public UserController(UserRepository userRepository, UserDaoModelMapper userDaoModelMapper, UserCredentialsRepository userCredentialsRepository, UserCredentialsDaoModelMapper userCredentialsDaoModelMapper, BCryptPasswordEncoder bCryptPasswordEncoder, PasswordGenerator passwordGenerator, EmailService emailService) {
        super(userRepository, userDaoModelMapper);
        this.userRepository = userRepository;
        this.userDaoModelMapper = userDaoModelMapper;
        this.userCredentialsRepository = userCredentialsRepository;
        this.userCredentialsDaoModelMapper = userCredentialsDaoModelMapper;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.passwordGenerator = passwordGenerator;
        this.emailService = emailService;
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
                    "Welcome to IQueue, your password is " + newPassword);

            return super.add(createdUser,
                    "/api/iqueue/user/" + createdUser.getUserId());

        } catch (Exception exception) {
            return ResponseEntity.status(500).build();
        }
    }

    @DeleteMapping(value = "{userId}", headers = {"Accept=application/json"})
    public ResponseEntity remove(@PathVariable Integer userId) {
        return super.remove(userId);
    }

    @PutMapping(value = "{userId}", headers = {"Accept=application/json", "Content-Type=application/json"})
    public ResponseEntity update(@PathVariable Integer userId, @RequestBody User user) {
        return super.update(userId, user);
    }

    @PutMapping(value = "{userId}/credentials", headers = {"Accept=application/json"})
    public ResponseEntity changePassword(@PathVariable int userId, @RequestBody UserCredentials newUserCredentials) {
        try {
            newUserCredentials.setPassword(bCryptPasswordEncoder.encode(newUserCredentials.getPassword()));
            userCredentialsRepository.save(userCredentialsDaoModelMapper.mapModelToDao(newUserCredentials));
            return ResponseEntity.ok().build();
        } catch (Exception exception) {
            return ResponseEntity.status(500).build();
        }
    }
}
