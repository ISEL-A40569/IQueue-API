package pt.ipl.isel.ps.iqueue.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pt.ipl.isel.ps.iqueue.model.OperatorUser;
import pt.ipl.isel.ps.iqueue.repository.OperatorUserRepository;

@RestController
public class OperatorUserController {

    @Autowired
    final private OperatorUserRepository operatorUserRepository;

    public OperatorUserController(OperatorUserRepository operatorUserRepository) {
        this.operatorUserRepository = operatorUserRepository;
    }

    @GetMapping(value = "/api/iqueue/operator/{operatorId}/user", headers = {"Accept=application/json"})
    public ResponseEntity getOperatorUsers(@PathVariable int operatorId) {
        try {
            return ResponseEntity.ok(operatorUserRepository.getOperatorUsers(operatorId));
        } catch (EmptyResultDataAccessException emptyResultDataAccessException) {
            return ResponseEntity.status(404).build();
        }
        catch (Exception exception) {
            return ResponseEntity.status(500).build();
        }
    }

    @GetMapping(value = "/api/iqueue/operator/user/{userId}", headers = {"Accept=application/json"})
    public ResponseEntity getUserOperator(@PathVariable int userId) {
        try {
            return ResponseEntity.ok(operatorUserRepository.getUserOperator(userId));
        } catch (EmptyResultDataAccessException emptyResultDataAccessException) {
            return ResponseEntity.status(404).build();
        }
        catch (Exception exception) {
            return ResponseEntity.status(500).build();
        }
    }

    @GetMapping(value = "/api/iqueue/operator/user", headers = {"Accept=application/json"})
    public ResponseEntity getAll() {
        try {
            return ResponseEntity.ok(operatorUserRepository.getAll());
        } catch (EmptyResultDataAccessException emptyResultDataAccessException) {
            return ResponseEntity.status(404).build();
        }
        catch (Exception exception) {
            return ResponseEntity.status(500).build();
        }
    }

    @PostMapping(value = "/api/iqueue/operator/user", headers = {"Accept=application/json", "Content-Type=application/json"})
    public ResponseEntity add(@RequestBody OperatorUser operatorUser) {
        try {
            if (operatorUserRepository.add(operatorUser)) {
                return ResponseEntity
                        .status(201)
//                        .header("Location", "/api/iqueue/operator/" + operatorUser.getOperatorId() +
//                                "/user/" + operatorUser.getUserId())
                        .build();
            }
            else {
                return ResponseEntity.status(409).build();
            }
        } catch (Exception exception) {
            return ResponseEntity.status(500).build();
        }
    }

    @DeleteMapping("/api/iqueue/operator/{operatorId}/user/{userId}")
    public ResponseEntity remove(@PathVariable int operatorId, @PathVariable int userId) {
        try {
            if (operatorUserRepository.remove(operatorId, userId)){
                return ResponseEntity.ok().build();
            } else {
                return ResponseEntity.status(404).build();
            }
        } catch (Exception exception) {
            return ResponseEntity.status(500).build();
        }
    }
}
