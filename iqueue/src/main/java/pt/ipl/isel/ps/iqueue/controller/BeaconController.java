package pt.ipl.isel.ps.iqueue.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pt.ipl.isel.ps.iqueue.model.Beacon;
import pt.ipl.isel.ps.iqueue.model.Operator;
import pt.ipl.isel.ps.iqueue.repository.BeaconRepository;
import pt.ipl.isel.ps.iqueue.repository.Repository;

@RestController
@RequestMapping("/api/iqueue/beacon")
public class BeaconController extends Controller<Beacon> {

    public BeaconController(BeaconRepository beaconRepository) {
        super(beaconRepository);
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
        return super.add(beacon, "/api/iqueue/beacon");
    }

    @DeleteMapping(value = "{beaconId}")
    public ResponseEntity remove(@PathVariable int beaconId) {
        return super.remove(beaconId);
    }

    @PutMapping(value = "{beaconId}", headers = {"Accept=application/json", "Content-Type=application/json"})
    public ResponseEntity update(@PathVariable int beaconId, @RequestBody Beacon beacon) {
        beacon.setBeaconId(beaconId);
        return super.update(beacon);
    }
}
