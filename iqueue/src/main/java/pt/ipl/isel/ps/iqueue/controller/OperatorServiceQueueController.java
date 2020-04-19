package pt.ipl.isel.ps.iqueue.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pt.ipl.isel.ps.iqueue.model.OperatorServiceQueue;
import pt.ipl.isel.ps.iqueue.repository.OperatorServiceQueueRepository;

@RestController
public class OperatorServiceQueueController {

    @Autowired
    private final OperatorServiceQueueRepository operatorServiceQueueRepository;

    public OperatorServiceQueueController(OperatorServiceQueueRepository operatorServiceQueueRepository) {
        this.operatorServiceQueueRepository = operatorServiceQueueRepository;
    }

    @GetMapping(value = "/api/iqueue/operator/{operatorId}/servicequeue", headers = {"Accept=application/json"})
    public ResponseEntity getOperatorServiceQueues(@PathVariable int operatorId) {
        try {
            return ResponseEntity.ok(operatorServiceQueueRepository.getOperatorServiceQueues(operatorId));
        } catch (EmptyResultDataAccessException emptyResultDataAccessException) {
            return ResponseEntity.status(404).build();
        }
        catch (Exception exception) {
            return ResponseEntity.status(500).build();
        }
    }

    @GetMapping(value = "/api/iqueue/operator/{operatorId}/servicequeue/{serviceQueueId}", headers = {"Accept=application/json"})
    public ResponseEntity getOperatorServiceQueue(@PathVariable int operatorId, @PathVariable int serviceQueueId) {
        try {
            return ResponseEntity.ok(operatorServiceQueueRepository.getOperatorServiceQueue(operatorId, serviceQueueId));
        } catch (EmptyResultDataAccessException emptyResultDataAccessException) {
            return ResponseEntity.status(404).build();
        }
        catch (Exception exception) {
            return ResponseEntity.status(500).build();
        }
    }

    @GetMapping(value = "/api/iqueue/operator/servicequeue", headers = {"Accept=application/json"})
    public ResponseEntity getAll() {
        try {
            return ResponseEntity.ok(operatorServiceQueueRepository.getAll());
        } catch (EmptyResultDataAccessException emptyResultDataAccessException) {
            return ResponseEntity.status(404).build();
        }
        catch (Exception exception) {
            return ResponseEntity.status(500).build();
        }
    }

    @PostMapping(value = "/api/iqueue/operator/servicequeue", headers = {"Accept=application/json", "Content-Type=application/json"})
    public ResponseEntity add(@RequestBody OperatorServiceQueue operatorServiceQueue) {
        try {
            int insertedId = operatorServiceQueueRepository.add(operatorServiceQueue);
            operatorServiceQueue.setServiceQueueId(insertedId);
            if (insertedId != 0) {
                return ResponseEntity
                        .status(201)
                        .header("Location", "/api/iqueue/operator/" + operatorServiceQueue.getOperatorId() +
                                "/servicequeue/" + insertedId)
                        .body(operatorServiceQueue);
            }
            else {
                return ResponseEntity.status(409).build();
            }
        } catch (Exception exception) {
            return ResponseEntity.status(500).build();
        }
    }

    @DeleteMapping("/api/iqueue/operator/{operatorId}/servicequeue/{serviceQueueId}")
    public ResponseEntity remove(@PathVariable int operatorId, @PathVariable int serviceQueueId) {
        try {
            if (operatorServiceQueueRepository.remove(operatorId, serviceQueueId)) {
                return ResponseEntity.ok().build();
            } else {
                return ResponseEntity.status(404).build();
            }
        }
        catch (Exception exception) {
            return ResponseEntity.status(500).build();
        }
    }

    @PutMapping(value = "/api/iqueue/operator/{operatorId}/servicequeue/{serviceQueueId}",
            headers = {"Accept=application/json", "Content-Type=application/json"})
    public ResponseEntity update(@PathVariable int operatorId, @PathVariable int serviceQueueId,
                                 @RequestBody OperatorServiceQueue operatorServiceQueue) {
        operatorServiceQueue.setOperatorId(operatorId);
        operatorServiceQueue.setServiceQueueId(serviceQueueId);
        try {
            if (operatorServiceQueueRepository.update(operatorServiceQueue)) {
                return ResponseEntity.ok().body(operatorServiceQueue);
            } else {
                return ResponseEntity.status(404).build();
            }
        }
        catch (Exception exception) {
            return ResponseEntity.status(500).build();
        }
    }
}
