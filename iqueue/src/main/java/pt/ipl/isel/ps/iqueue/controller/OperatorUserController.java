package pt.ipl.isel.ps.iqueue.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pt.ipl.isel.ps.iqueue.dao.OperatorUserDao;
import pt.ipl.isel.ps.iqueue.dao.embeddable.OperatorUserIds;
import pt.ipl.isel.ps.iqueue.mapping.OperatorUserDaoModelMapper;
import pt.ipl.isel.ps.iqueue.model.OperatorUser;
import pt.ipl.isel.ps.iqueue.repository.OperatorUserRepository;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/iqueue/operator")
public class OperatorUserController extends Controller<OperatorUser, OperatorUserIds, OperatorUserDao> {

    @Autowired
    private final OperatorUserRepository operatorUserRepository;

    @Autowired
    private final OperatorUserDaoModelMapper operatorUserDaoModelMapper;

    public OperatorUserController(OperatorUserRepository operatorUserRepository, OperatorUserDaoModelMapper operatorUserDaoModelMapper) {
        super(operatorUserRepository, operatorUserDaoModelMapper);
        this.operatorUserRepository = operatorUserRepository;
        this.operatorUserDaoModelMapper = operatorUserDaoModelMapper;
    }

    @GetMapping(value = "{operatorId}/user", headers = {"Accept=application/json"})
    public ResponseEntity getOperatorUsers(@PathVariable int operatorId) {
        return super.getSome(operatorUserRepository
                .findAll()
                .stream()
                .filter(operatorUserDao -> operatorUserDao.getOperatorUserIds().getOperatorId() == operatorId)
                .collect(Collectors.toList())
        );
    }

    @GetMapping(value = "user/{userId}", headers = {"Accept=application/json"})
    public ResponseEntity getUserOperator(@PathVariable int userId) {
        return super.getSome(operatorUserRepository
                .findAll()
                .stream()
                .filter(operatorUserDao -> operatorUserDao.getOperatorUserIds().getUserId() == userId)
                .collect(Collectors.toList())
        );
    }

    @PostMapping(value = "user", headers = {"Accept=application/json", "Content-Type=application/json"})
    public ResponseEntity add(@RequestBody OperatorUser operatorUser) {
        try {
            operatorUserRepository.save(operatorUserDaoModelMapper.mapModelToDao(operatorUser));

            return super.add(operatorUser, "/api/iqueue/operator/" + operatorUser.getOperatorId() +
                    "/user/" + operatorUser.getUserId());
        } catch (Exception exception) {
            return ResponseEntity.status(500).build();
        }
    }

    @DeleteMapping("{operatorId}/user/{userId}")
    public ResponseEntity remove(@PathVariable int operatorId, @PathVariable int userId) {
        return super.remove(new OperatorUserIds(operatorId, userId));
    }
}
