package pt.ipl.isel.ps.iqueue.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pt.ipl.isel.ps.iqueue.dao.UserCredentialsDao;
import pt.ipl.isel.ps.iqueue.repository.UserCredentialsRepository;
import pt.ipl.isel.ps.iqueue.repository.UserRepository;
import pt.ipl.isel.ps.iqueue.utils.ErrorNotificationService;

import java.util.Optional;

@RestController
@RequestMapping("/api/iqueue/login")
public class LoginController {

    @Autowired
    private final UserCredentialsRepository userCredentialsRepository;

    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private final ErrorNotificationService errorNotificationService;

    public LoginController(UserCredentialsRepository userCredentialsRepository, UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder, ErrorNotificationService errorNotificationService) {
        this.userCredentialsRepository = userCredentialsRepository;
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.errorNotificationService = errorNotificationService;
    }

    @PostMapping
    public ResponseEntity login(@RequestBody UserCredentialsDao userCredentials) {
        try {
//            String encode = bCryptPasswordEncoder.encode(userCredentials.getPassword());
            Optional<UserCredentialsDao> optionalUserCredentials = userCredentialsRepository.findById(userCredentials.getUserId());

            if (!optionalUserCredentials.isPresent())
                return ResponseEntity.status(404).build();

            if (!bCryptPasswordEncoder.matches(userCredentials.getPassword(), optionalUserCredentials.get().getPassword()))
                return ResponseEntity.status(401).build();

            return ResponseEntity.ok(userRepository.findById(userCredentials.getUserId()));
        } catch (Exception exception) {
            errorNotificationService.sendErrorToAdministrators(exception.getMessage());
            return ResponseEntity.status(500).build();
        }
    }

}
