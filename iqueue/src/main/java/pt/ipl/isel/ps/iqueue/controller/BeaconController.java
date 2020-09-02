package pt.ipl.isel.ps.iqueue.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pt.ipl.isel.ps.iqueue.dao.BeaconDao;
import pt.ipl.isel.ps.iqueue.mapping.BeaconDaoModelMapper;
import pt.ipl.isel.ps.iqueue.mapping.OperatorBeaconDaoModelMapper;
import pt.ipl.isel.ps.iqueue.model.Beacon;
import pt.ipl.isel.ps.iqueue.model.EddystoneUid;
import pt.ipl.isel.ps.iqueue.model.OperatorBeacon;
import pt.ipl.isel.ps.iqueue.repository.BeaconRepository;
import pt.ipl.isel.ps.iqueue.repository.OperatorBeaconRepository;
import pt.ipl.isel.ps.iqueue.utils.ErrorNotificationService;

import javax.transaction.Transactional;

@RestController
@RequestMapping("/api/iqueue/beacon")
public class BeaconController extends Controller<Beacon, Integer, BeaconDao> {

    @Autowired
    private final BeaconRepository beaconRepository;

    @Autowired
    private final OperatorBeaconRepository operatorBeaconRepository;

    @Autowired
    private final BeaconDaoModelMapper beaconDaoModelMapper;

    @Autowired
    private final OperatorBeaconDaoModelMapper operatorBeaconDaoModelMapper;

    @Autowired
    private final ErrorNotificationService errorNotificationService;

    public BeaconController(BeaconRepository beaconRepository, OperatorBeaconRepository operatorBeaconRepository, BeaconDaoModelMapper beaconDaoModelMapperM, OperatorBeaconDaoModelMapper operatorBeaconDaoModelMapper, ErrorNotificationService errorNotificationService) {
        super(beaconRepository, beaconDaoModelMapperM, errorNotificationService);
        this.beaconRepository = beaconRepository;
        this.operatorBeaconRepository = operatorBeaconRepository;
        this.beaconDaoModelMapper = beaconDaoModelMapperM;
        this.operatorBeaconDaoModelMapper = operatorBeaconDaoModelMapper;
        this.errorNotificationService = errorNotificationService;
    }

    @GetMapping(value = "{beaconId}", headers = {"Accept=application/json"})
    public ResponseEntity getById(@PathVariable int beaconId) {
        return super.getById(beaconId);
    }

    @GetMapping(headers = {"Accept=application/json"})
    public ResponseEntity getAll() {
        return super.getAll();
    }

    @PostMapping(value = "/eddystoneUid", headers = {"Accept=application/json", "Content-Type=application/json"})
    public ResponseEntity getOperatorBeaconByEddystoneUid(@RequestBody EddystoneUid eddystoneUid) {
        try {
            Beacon beacon = beaconDaoModelMapper
                    .mapDaoToModel(beaconRepository
                            .findByNamespaceIdAndInstanceId(eddystoneUid.getNamespaceId(), eddystoneUid.getInstanceId()));

            OperatorBeacon operatorBeacon = operatorBeaconDaoModelMapper
                    .mapDaoToModel(operatorBeaconRepository
                            .findByOperatorBeaconIdsBeaconId(beacon.getBeaconId()));

            return ResponseEntity.ok(operatorBeacon);

        } catch (Exception exception) {
            return ResponseEntity.status(500).build();
        }
    }

    @PostMapping(headers = {"Accept=application/json", "Content-Type=application/json"})
    public ResponseEntity add(@RequestBody Beacon beacon) {
        try {
            Beacon createdBeacon = beaconDaoModelMapper.mapDaoToModel(beaconRepository
                    .save(beaconDaoModelMapper.mapModelToDao(beacon)));

            return super.add(createdBeacon, "/api/iqueue/beacon/" + createdBeacon.getBeaconId());
        } catch (Exception exception) {
            return ResponseEntity.status(500).build();
        }

    }

    @DeleteMapping(value = "{beaconId}")
    @Transactional
    public ResponseEntity remove(@PathVariable int beaconId) {
        operatorBeaconRepository.deleteByOperatorBeaconIdsBeaconId(beaconId);
        return super.remove(beaconId);
    }

    @PutMapping(value = "{beaconId}", headers = {"Accept=application/json", "Content-Type=application/json"})
    public ResponseEntity update(@PathVariable int beaconId, @RequestBody Beacon beacon) {
        beacon.setBeaconId(beaconId);
        return super.update(beaconId, beacon);
    }
}
