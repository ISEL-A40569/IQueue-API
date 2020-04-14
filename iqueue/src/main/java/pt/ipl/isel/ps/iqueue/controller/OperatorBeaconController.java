package pt.ipl.isel.ps.iqueue.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pt.ipl.isel.ps.iqueue.model.OperatorBeacon;
import pt.ipl.isel.ps.iqueue.repository.OperatorBeaconRepository;

@RestController
public class OperatorBeaconController {

    @Autowired
    final private OperatorBeaconRepository operatorBeaconRepository;

    public OperatorBeaconController(OperatorBeaconRepository operatorBeaconRepository) {
        this.operatorBeaconRepository = operatorBeaconRepository;
    }

    @GetMapping(value = "/api/iqueue/operator/{operatorId}/beacon", headers = {"Accept=application/json"})
    public ResponseEntity getOperatorBeacons(@PathVariable int operatorId) {
        try {
            return ResponseEntity.ok(operatorBeaconRepository.getOperatorBeacons(operatorId));
        } catch (EmptyResultDataAccessException emptyResultDataAccessException) {
            return ResponseEntity.status(404).build();
        }
        catch (Exception exception) {
            return ResponseEntity.status(500).build();
        }
    }

    @GetMapping(value = "/api/iqueue/operator/beacon/{beaconId}", headers = {"Accept=application/json"})
    public ResponseEntity getBeaconOperator(@PathVariable int beaconId) {
        try {
            return ResponseEntity.ok(operatorBeaconRepository.getBeaconOperator(beaconId));
        } catch (EmptyResultDataAccessException emptyResultDataAccessException) {
            return ResponseEntity.status(404).build();
        }
        catch (Exception exception) {
            return ResponseEntity.status(500).build();
        }
    }

    @GetMapping(value = "/api/iqueue/operator/beacon", headers = {"Accept=application/json"})
    public ResponseEntity getAll() {
        try {
            return ResponseEntity.ok(operatorBeaconRepository.getAll());
        } catch (EmptyResultDataAccessException emptyResultDataAccessException) {
            return ResponseEntity.status(404).build();
        }
        catch (Exception exception) {
            return ResponseEntity.status(500).build();
        }
    }

    @PostMapping(value = "/api/iqueue/operator/beacon", headers = {"Accept=application/json", "Content-Type=application/json"})
    public ResponseEntity add(@RequestBody OperatorBeacon operatorBeacon) {
        try {
            if (operatorBeaconRepository.add(operatorBeacon)) {
                return ResponseEntity
                        .status(201)
//                        .header("Location", "/api/iqueue/operator/" + operatorBeacon.getOperatorId() +
//                                "/beacon/" + operatorBeacon.getBeaconId())
                        .build();
            }
            else {
                return ResponseEntity.status(409).build();
            }
        } catch (Exception exception) {
            return ResponseEntity.status(500).build();
        }
    }

    @DeleteMapping("/api/iqueue/operator/{operatorId}/beacon/{beaconId}")
    public ResponseEntity remove(@PathVariable int operatorId, @PathVariable int beaconId) {
        try {
            return ResponseEntity.ok(operatorBeaconRepository.remove(operatorId, beaconId));
        } catch (EmptyResultDataAccessException emptyResultDataAccessException) {
            return ResponseEntity.status(404).build();
        }
        catch (Exception exception) {
            return ResponseEntity.status(500).build();
        }
    }

}
