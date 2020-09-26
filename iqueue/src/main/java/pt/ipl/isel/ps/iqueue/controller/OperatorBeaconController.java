package pt.ipl.isel.ps.iqueue.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pt.ipl.isel.ps.iqueue.dao.OperatorBeaconDao;
import pt.ipl.isel.ps.iqueue.dao.keys.OperatorBeaconIds;
import pt.ipl.isel.ps.iqueue.mapping.OperatorBeaconDaoModelMapper;
import pt.ipl.isel.ps.iqueue.model.OperatorBeacon;
import pt.ipl.isel.ps.iqueue.repository.OperatorBeaconRepository;
import pt.ipl.isel.ps.iqueue.utils.ErrorNotificationService;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/iqueue/operator")
public class OperatorBeaconController extends Controller<OperatorBeacon, OperatorBeaconIds, OperatorBeaconDao> {

    @Autowired
    private final OperatorBeaconRepository operatorBeaconRepository;

    @Autowired
    private final OperatorBeaconDaoModelMapper operatorBeaconDaoModelMapper;

    @Autowired
    private final ErrorNotificationService errorNotificationService;

    public OperatorBeaconController(OperatorBeaconRepository operatorBeaconRepository, OperatorBeaconDaoModelMapper operatorBeaconDaoModelMapper, ErrorNotificationService errorNotificationService) {
        super(operatorBeaconRepository, operatorBeaconDaoModelMapper, errorNotificationService);
        this.operatorBeaconRepository = operatorBeaconRepository;
        this.operatorBeaconDaoModelMapper = operatorBeaconDaoModelMapper;
        this.errorNotificationService = errorNotificationService;
    }

    @GetMapping(value = "{operatorId}/beacon", headers = {"Accept=application/json"})
    public ResponseEntity getOperatorBeacons(@PathVariable int operatorId) {
        return super.getSome(operatorBeaconRepository
                .findAll()
                .stream()
                .filter(operatorBeaconDao -> operatorBeaconDao.getOperatorBeaconIds().getOperatorId() == operatorId)
                .collect(Collectors.toList())
        );
    }

    @GetMapping(value = "beacon/{beaconId}", headers = {"Accept=application/json"})
    public ResponseEntity getBeaconOperator(@PathVariable int beaconId) {
        return super.getSome(operatorBeaconRepository
                .findAll()
                .stream()
                .filter(operatorBeaconDao -> operatorBeaconDao.getOperatorBeaconIds().getBeaconId() == beaconId)
                .collect(Collectors.toList())
        );
    }

    @GetMapping(value = "beacon", headers = {"Accept=application/json"})
    public ResponseEntity getAll() {
        return super.getAll();
    }

    @PostMapping(value = "beacon", headers = {"Accept=application/json", "Content-Type=application/json"})
    public ResponseEntity add(@RequestBody OperatorBeacon operatorBeacon) {
        try {
            operatorBeaconRepository.save(operatorBeaconDaoModelMapper.mapModelToDao(operatorBeacon));

            return super.add(operatorBeacon, "/api/iqueue/operator/" + operatorBeacon.getOperatorId() +
                    "/beacon/" + operatorBeacon.getBeaconId());

        } catch (Exception exception) {
            errorNotificationService.sendErrorToAdministrators(exception.getMessage());
            return ResponseEntity.status(500).build();
        }
    }

    @DeleteMapping("{operatorId}/beacon/{beaconId}")
    public ResponseEntity remove(@PathVariable int operatorId, @PathVariable int beaconId) {
        return super.remove(new OperatorBeaconIds(operatorId, beaconId));
    }

}
