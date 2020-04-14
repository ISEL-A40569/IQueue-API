package pt.ipl.isel.ps.iqueue.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pt.ipl.isel.ps.iqueue.model.User;
import pt.ipl.isel.ps.iqueue.repository.UserRepository;

@RestController
@RequestMapping("/api/iqueue/user")
public class UserController {

    @Autowired
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping(value = "{userId}", headers = {"Accept=application/json"})
    public ResponseEntity getById(@PathVariable int userId) {
        try {
            return ResponseEntity.ok(userRepository.getById(userId));
        } catch (EmptyResultDataAccessException emptyResultDataAccessException) {
            return ResponseEntity.status(404).build();
        }
        catch (Exception exception) {
            return ResponseEntity.status(500).build();
        }
    }

    @GetMapping(headers = {"Accept=application/json"})
    public ResponseEntity getAll() {
        try {
            return ResponseEntity.ok(userRepository.getAll());
        } catch (EmptyResultDataAccessException emptyResultDataAccessException) {
            return ResponseEntity.status(404).build();
        }
        catch (Exception exception) {
            return ResponseEntity.status(500).build();
        }
    }

    @PostMapping(headers = {"Accept=application/json", "Content-Type=application/json"})
    public ResponseEntity add(@RequestBody User user) {
        int insertdUserId = userRepository.add(user);
        user.setUserId(insertdUserId);
        try {
            if (insertdUserId != 0) {
                return ResponseEntity
                        .status(201)
                        .header("Location", "/api/iqueue/user/" + insertdUserId)
                        .body(user);
            }
            else {
                return ResponseEntity.status(409).build();
            }
        } catch (Exception exception) {
            return ResponseEntity.status(500).build();
        }
    }

    @DeleteMapping(value = "{userId}", headers = {"Accept=application/json"})
    public ResponseEntity remove(@PathVariable int userId) {
        try {
            if (userRepository.remove(userId)) {
                return ResponseEntity.ok().build();
            }
            else {
                return ResponseEntity.status(404).build();
            }
        } catch (Exception exception) {
            return ResponseEntity.status(500).build();
        }
    }

    @PutMapping(value = "{userId}", headers = {"Accept=application/json", "Content-Type=application/json"})
    public ResponseEntity update(@PathVariable int userId, @RequestBody User user) {
        user.setUserId(userId);
        try {
            if (userRepository.update(user)) {
                return ResponseEntity.ok(user);
            }
            else {
                return ResponseEntity.status(404).build();
            }
        } catch (Exception exception) {
            return ResponseEntity.status(500).build();
        }
    }
}
