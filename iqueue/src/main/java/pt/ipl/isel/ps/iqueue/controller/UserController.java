package pt.ipl.isel.ps.iqueue.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import pt.ipl.isel.ps.iqueue.model.User;
import pt.ipl.isel.ps.iqueue.model.UserCredentials;
import pt.ipl.isel.ps.iqueue.repository.UserCredentialsRepository;
import pt.ipl.isel.ps.iqueue.repository.UserRepository;
import pt.ipl.isel.ps.iqueue.utils.EmailService;
import pt.ipl.isel.ps.iqueue.utils.PasswordGenerator;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/iqueue/user")
public class UserController {

    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private final UserCredentialsRepository userCredentialsRepository;

    @Autowired
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private final PasswordGenerator passwordGenerator;

    @Autowired
    private final EmailService emailService;

    public UserController(UserRepository userRepository, UserCredentialsRepository userCredentialsRepository, BCryptPasswordEncoder bCryptPasswordEncoder, PasswordGenerator passwordGenerator, EmailService emailService) {
        this.userRepository = userRepository;
        this.userCredentialsRepository = userCredentialsRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.passwordGenerator = passwordGenerator;
        this.emailService = emailService;
    }

    @GetMapping(value = "{userId}", headers = {"Accept=application/json"})
    public ResponseEntity getById(@PathVariable int userId) {
        try {
            Optional<User> optionalUser = userRepository.findById(userId);
            if (optionalUser.isPresent()) {
                return ResponseEntity.ok(optionalUser.get());
            } else {
                return ResponseEntity.status(404).build();
            }
        }
        catch (Exception exception) {
            return ResponseEntity.status(500).build();
        }
    }

    @GetMapping(headers = {"Accept=application/json"})
    public ResponseEntity getAll() {
        try {
            List<User> userList = userRepository.findAll();
            if (!userList.isEmpty()) {
                return ResponseEntity.ok(userList);
            } else {
                return ResponseEntity.status(404).build();
            }
        }
        catch (Exception exception) {
            return ResponseEntity.status(500).build();
        }
    }

    @PostMapping(headers = {"Accept=application/json", "Content-Type=application/json"})
    public ResponseEntity add(@RequestBody User user) {
        try {
            String newPassword = passwordGenerator.generatePassword();

            UserCredentials userCredentials = new UserCredentials();
            userCredentials.setUserId(user.getUserId());
            userCredentials.setPassword(bCryptPasswordEncoder.encode(newPassword));
            userCredentialsRepository.save(userCredentials);

            User createdUser = userRepository.save(user);

            emailService.sendEmail(user.getEmail(),
                    "Welcome to IQueue, your password is " + newPassword);

            return ResponseEntity.status(201)
                    .header("Location", "/api/iqueue/user/" + createdUser.getUserId())
                    .body(user);

        } catch (Exception exception) {
            return ResponseEntity.status(500).build();
        }
    }

    @DeleteMapping(value = "{userId}", headers = {"Accept=application/json"})
    public ResponseEntity remove(@PathVariable int userId) {
        try {
            Optional<User> optionalUser = userRepository.findById(userId);
            if (optionalUser.isPresent()) {
                userRepository.delete(optionalUser.get());
                return ResponseEntity.ok().build();
            } else {
                return ResponseEntity.status(404).build();
            }
        } catch (Exception exception) {
            return ResponseEntity.status(500).build();
        }
    }

    @PutMapping(value = "{userId}", headers = {"Accept=application/json", "Content-Type=application/json"})
    public ResponseEntity update(@PathVariable int userId, @RequestBody User user) {
        try {
            Optional<User> optionalUser = userRepository.findById(userId);
            if (optionalUser.isPresent()) {
                user.setUserId(userId);

                // TODO: move this to a "Change Password" request
//                // If password was changed, encrypt the new password
//                if (user.getPassword() != null && !bCryptPasswordEncoder.matches(user.getPassword(), optionalUser.get().getPassword()))
//                    user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

                userRepository.save(user);
                return ResponseEntity.ok(user);
            } else {
                return ResponseEntity.status(404).build();
            }
        } catch (Exception exception) {
            return ResponseEntity.status(500).build();
        }
    }
}
