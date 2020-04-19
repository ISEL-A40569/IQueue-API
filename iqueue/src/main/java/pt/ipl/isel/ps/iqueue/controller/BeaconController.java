package pt.ipl.isel.ps.iqueue.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pt.ipl.isel.ps.iqueue.model.Beacon;
import pt.ipl.isel.ps.iqueue.model.Operator;
import pt.ipl.isel.ps.iqueue.repository.BeaconRepository;
import pt.ipl.isel.ps.iqueue.repository.Repository;

@RestController
@RequestMapping("/api/iqueue/beacon")
public class BeaconController {

    @Autowired
    private final BeaconRepository beaconRepository;

    public BeaconController(BeaconRepository beaconRepository) {
        this.beaconRepository = beaconRepository;
    }

    @GetMapping(value = "{beaconId}", headers = {"Accept=application/json"})
    public ResponseEntity getById(@PathVariable int beaconId) {
        try {
            return ResponseEntity.ok(beaconRepository.getById(beaconId));
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
            return ResponseEntity.ok(beaconRepository.getAll());
        } catch (EmptyResultDataAccessException emptyResultDataAccessException) {
            return ResponseEntity.status(404).build();
        }
        catch (Exception exception) {
            return ResponseEntity.status(500).build();
        }
    }

    @PostMapping(headers = {"Accept=application/json", "Content-Type=application/json"})
    public ResponseEntity add(@RequestBody Beacon beacon) {
        try {
            int insertedId = beaconRepository.add(beacon);
            if (insertedId != 0) {
                beacon.setBeaconId(insertedId);
                return ResponseEntity
                        .status(201)
                        .header("Location", "/api/iqueue/beacon/" + insertedId)
                        .body(beacon);
            }
            else {
                return ResponseEntity.status(409).build();
            }
        } catch (Exception exception) {
            return ResponseEntity.status(500).build();
        }

    }

    @DeleteMapping(value = "{beaconId}")
    public ResponseEntity remove(@PathVariable int beaconId) {
        try {
            if (beaconRepository.remove(beaconId)) {
                return ResponseEntity.ok().build();
            }
            else {
                return ResponseEntity.status(404).build();
            }
        } catch (Exception exception) {
            return ResponseEntity.status(500).build();
        }
    }

    @PutMapping(value = "{beaconId}", headers = {"Accept=application/json", "Content-Type=application/json"})
    public ResponseEntity update(@PathVariable int beaconId, @RequestBody Beacon beacon) {
        beacon.setBeaconId(beaconId);
        try {
            if (beaconRepository.update(beacon)) {
                return ResponseEntity.ok().body(beacon);
            }
            else {
                return ResponseEntity.status(404).build();
            }
        } catch (Exception exception) {
            return ResponseEntity.status(500).build();
        }
    }
}
