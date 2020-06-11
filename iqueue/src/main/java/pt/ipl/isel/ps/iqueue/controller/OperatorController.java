package pt.ipl.isel.ps.iqueue.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pt.ipl.isel.ps.iqueue.dao.OperatorDao;
import pt.ipl.isel.ps.iqueue.mapping.OperatorDaoModelMapper;
import pt.ipl.isel.ps.iqueue.model.Operator;
import pt.ipl.isel.ps.iqueue.repository.OperatorRepository;

//@CrossOrigin(origins = "https://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/api/iqueue/operator")
public class OperatorController extends Controller<Operator, Integer, OperatorDao> {

    @Autowired
    private final OperatorRepository operatorRepository;

    @Autowired
    private final OperatorDaoModelMapper operatorDaoModelMapper;


    public OperatorController(OperatorRepository operatorRepository, OperatorDaoModelMapper operatorDaoModelMapper) {
        super(operatorRepository, operatorDaoModelMapper);
        this.operatorRepository = operatorRepository;
        this.operatorDaoModelMapper = operatorDaoModelMapper;
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
        try {
            Operator createdOperator = operatorDaoModelMapper.mapDaoToModel(operatorRepository
                    .save(operatorDaoModelMapper.mapModelToDao(operator)));

            return super.add(createdOperator, "/api/iqueue/operator/" + createdOperator.getOperatorId());
        } catch (Exception exception) {
            return ResponseEntity.status(500).build();
        }
    }

    @DeleteMapping(value = "{operatorId}")
    public ResponseEntity remove(@PathVariable int operatorId) {
        return super.remove(operatorId);
    }

    @PutMapping(value = "{operatorId}", headers = {"Accept=application/json", "Content-Type=application/json"})
    public ResponseEntity update(@PathVariable int operatorId, @RequestBody Operator operator) {
        operator.setOperatorId(operatorId);
        return super.update(operatorId, operator);
    }
}
