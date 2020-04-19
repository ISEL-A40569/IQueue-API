package pt.ipl.isel.ps.iqueue.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pt.ipl.isel.ps.iqueue.model.Operator;
import pt.ipl.isel.ps.iqueue.repository.OperatorRepository;

@RestController
@RequestMapping("/api/iqueue/operator")
public class OperatorController {

    @Autowired
    private final OperatorRepository operatorRepository;

    public OperatorController(OperatorRepository operatorRepository) {
        this.operatorRepository = operatorRepository;
    }

    @GetMapping(value = "{operatorId}", headers = {"Accept=application/json"})
    public ResponseEntity getById(@PathVariable int operatorId) {
        try {
            return ResponseEntity.ok(operatorRepository.getById(operatorId));
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
            return ResponseEntity.ok(operatorRepository.getAll());
        } catch (EmptyResultDataAccessException emptyResultDataAccessException) {
            return ResponseEntity.status(404).build();
        }
        catch (Exception exception) {
            return ResponseEntity.status(500).build();
        }
    }

    @PostMapping(headers = {"Accept=application/json", "Content-Type=application/json"})
    public ResponseEntity add(@RequestBody Operator operator) {
        try {
            int insertedId = operatorRepository.add(operator);
            if (insertedId != 0) {
                operator.setOperatorId(insertedId);
                return ResponseEntity
                        .status(201)
                        .header("Location", "/api/iqueue/operator/" + insertedId)
                        .body(operator);
            }
            else {
                return ResponseEntity.status(409).build();
            }
        } catch (Exception exception) {
            return ResponseEntity.status(500).build();
        }    }

    @DeleteMapping(value = "{operatorId}")
    public ResponseEntity remove(@PathVariable int operatorId) {
        try {
            if (operatorRepository.remove(operatorId)) {
                return ResponseEntity.ok().build();
            }
            else {
                return ResponseEntity.status(404).build();
            }
        } catch (Exception exception) {
            return ResponseEntity.status(500).build();
        }
    }

    @PutMapping(value = "{operatorId}", headers = {"Accept=application/json", "Content-Type=application/json"})
    public ResponseEntity update(@PathVariable int operatorId, @RequestBody Operator operator) {
        operator.setOperatorId(operatorId);
        try {
            if (operatorRepository.update(operator)) {
                return ResponseEntity.ok().body(operator);
            }
            else {
                return ResponseEntity.status(404).build();
            }
        } catch (Exception exception) {
            return ResponseEntity.status(500).build();
        }
    }
}
