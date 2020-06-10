package pt.ipl.isel.ps.iqueue.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pt.ipl.isel.ps.iqueue.dao.BeaconDao;
import pt.ipl.isel.ps.iqueue.mapping.BeaconDaoModelMapper;
import pt.ipl.isel.ps.iqueue.model.Beacon;
import pt.ipl.isel.ps.iqueue.repository.BeaconRepository;

@RestController
@RequestMapping("/api/iqueue/beacon")
public class BeaconController extends Controller<Beacon, Integer, BeaconDao> {

    @Autowired
    private final BeaconRepository beaconRepository;

    @Autowired
    private final BeaconDaoModelMapper beaconDaoModelMapperM;

    public BeaconController(BeaconRepository beaconRepository, BeaconDaoModelMapper beaconDaoModelMapperM) {
        super(beaconRepository, beaconDaoModelMapperM);
        this.beaconRepository = beaconRepository;
        this.beaconDaoModelMapperM = beaconDaoModelMapperM;
    }

    @GetMapping(value = "{beaconId}", headers = {"Accept=application/json"})
    public ResponseEntity getById(@PathVariable int beaconId) {
        return super.getById(beaconId);
    }

    @GetMapping(headers = {"Accept=application/json"})
    public ResponseEntity getAll() {
        return super.getAll();
    }

    @PostMapping(headers = {"Accept=application/json", "Content-Type=application/json"})
    public ResponseEntity add(@RequestBody Beacon beacon) {
        try {
            Beacon createdBeacon = beaconDaoModelMapperM.mapDaoToModel(beaconRepository
                    .save(beaconDaoModelMapperM.mapModelToDao(beacon)));

            return super.add(createdBeacon, "/api/iqueue/beacon/" + createdBeacon.getBeaconId());
        } catch (Exception exception) {
            return ResponseEntity.status(500).build();
        }

    }

    @DeleteMapping(value = "{beaconId}")
    public ResponseEntity remove(@PathVariable int beaconId) {
        return super.remove(beaconId);
    }

    @PutMapping(value = "{beaconId}", headers = {"Accept=application/json", "Content-Type=application/json"})
    public ResponseEntity update(@PathVariable int beaconId, @RequestBody Beacon beacon) {
        return super.update(beaconId, beacon);
    }
}
