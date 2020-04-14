package pt.ipl.isel.ps.iqueue.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pt.ipl.isel.ps.iqueue.model.Operator;
import pt.ipl.isel.ps.iqueue.repository.OperatorRepository;

@RestController
@RequestMapping("/api/iqueue/operator")
public class OperatorController extends Controller<Operator> {

    public OperatorController(OperatorRepository operatorRepository) {
        super(operatorRepository);
    }

    @GetMapping(value = "{operatorId}", headers = {"Accept=application/json"})
    public ResponseEntity getById(@PathVariable int operatorId) {
        return super.getById(operatorId);
    }

    @GetMapping(headers = {"Accept=application/json"})
    public ResponseEntity getAll() {
        return super.getAll();
    }

    @PostMapping(headers = {"Accept=application/json", "Content-Type=application/json"})
    public ResponseEntity add(@RequestBody Operator operator) {
        return super.add(operator, "/api/iqueue/operator");
    }

    @DeleteMapping(value = "{operatorId}")
    public ResponseEntity remove(@PathVariable int operatorId) {
        return super.remove(operatorId);
    }

    @PutMapping(value = "{operatorId}", headers = {"Accept=application/json", "Content-Type=application/json"})
    public ResponseEntity update(@PathVariable int operatorId, @RequestBody Operator operator) {
        operator.setOperatorId(operatorId);
        return super.update(operator);
    }
}
