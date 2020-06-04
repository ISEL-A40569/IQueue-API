package pt.ipl.isel.ps.iqueue.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pt.ipl.isel.ps.iqueue.model.UserCredentials;
import pt.ipl.isel.ps.iqueue.repository.UserCredentialsRepository;
import pt.ipl.isel.ps.iqueue.repository.UserRepository;

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

    public LoginController(UserCredentialsRepository userCredentialsRepository, UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userCredentialsRepository = userCredentialsRepository;
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @PostMapping
    public ResponseEntity login(@RequestBody UserCredentials userCredentials) {
        try {
            String encode = bCryptPasswordEncoder.encode(userCredentials.getPassword());
            Optional<UserCredentials> optionalUserCredentials = userCredentialsRepository.findById(userCredentials.getUserId());

            if (!optionalUserCredentials.isPresent())
                return ResponseEntity.status(404).build();

            if (!bCryptPasswordEncoder.matches(userCredentials.getPassword(), optionalUserCredentials.get().getPassword()))
                return ResponseEntity.status(401).build();

            return ResponseEntity.ok(userRepository.findById(userCredentials.getUserId()));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.status(500).build();
        }
    }

}
