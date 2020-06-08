package pt.ipl.isel.ps.iqueue.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pt.ipl.isel.ps.iqueue.dao.DeskDao;
import pt.ipl.isel.ps.iqueue.repository.DeskRepository;

@RestController
public class ServiceQueueDeskController {

    @Autowired
    final private DeskRepository serviceQueueDeskRepository;

    public ServiceQueueDeskController(DeskRepository serviceQueueDeskRepository) {
        this.serviceQueueDeskRepository = serviceQueueDeskRepository;
    }

    @GetMapping(value = "/api/iqueue/operator/servicequeue/desk/{deskId}", headers = {"Accept=application/json"})
    public ResponseEntity getServiceQueueDesk(@PathVariable int deskId) {
        try {
            return ResponseEntity.ok(serviceQueueDeskRepository.getServiceQueueDesk(deskId));
        } catch (EmptyResultDataAccessException emptyResultDataAccessException) {
            return ResponseEntity.status(404).build();
        }
        catch (Exception exception) {
            return ResponseEntity.status(500).build();
        }
    }

    @GetMapping(value = "/api/iqueue/operator/{operatorId}/servicequeue/{serviceQueueId}/desk", headers = {"Accept=application/json"})
    public ResponseEntity getServiceQueueDesks(@PathVariable int operatorId, @PathVariable int serviceQueueId) {
        try {
            return ResponseEntity.ok(serviceQueueDeskRepository.getServiceQueueDesks(operatorId, serviceQueueId));
        } catch (EmptyResultDataAccessException emptyResultDataAccessException) {
            return ResponseEntity.status(404).build();
        }
        catch (Exception exception) {
            return ResponseEntity.status(500).build();
        }
    }

    @GetMapping(value = "/api/iqueue/operator/servicequeue/desk", headers = {"Accept=application/json"})
    public ResponseEntity getAll() {
        try {
            return ResponseEntity.ok(serviceQueueDeskRepository.getAll());
        } catch (EmptyResultDataAccessException emptyResultDataAccessException) {
            return ResponseEntity.status(404).build();
        }
        catch (Exception exception) {
            return ResponseEntity.status(500).build();
        }
    }

    @PostMapping(value = "/api/iqueue/operator/servicequeue/desk", headers = {"Accept=application/json", "Content-Type=application/json"})
    public ResponseEntity add(@RequestBody DeskDao serviceQueueDesk) {
        try {
            int insertedId = serviceQueueDeskRepository.add(serviceQueueDesk);
            if (insertedId != 0) {
                serviceQueueDesk.setDeskId(insertedId);
                return ResponseEntity
                        .status(201)
                        .header("Location", "/api/iqueue/operator/" + serviceQueueDesk.getOperatorId() +
                                "/servicequeue/" + serviceQueueDesk.getServiceQueueId() +
                                "/desk/" + insertedId)
                        .body(serviceQueueDesk);
            }
            else {
                return ResponseEntity.status(409).build();
            }
        } catch (Exception exception) {
            return ResponseEntity.status(500).build();
        }
    }

    @DeleteMapping(value = "/api/iqueue/operator/{operatorId}/servicequeue/{serviceQueueId}/desk/{deskId}")
    public ResponseEntity remove(@PathVariable int operatorId, @PathVariable int serviceQueueId,
                                 @PathVariable int deskId) {
        try {
            if (serviceQueueDeskRepository.remove(operatorId, serviceQueueId, deskId)) {
                return ResponseEntity.ok().build();
            }
            else {
                return ResponseEntity.status(404).build();
            }
        } catch (Exception exception) {
            return ResponseEntity.status(500).build();
        }
    }

    @PutMapping(value = "/api/iqueue/operator/servicequeue/desk/{deskId}")
    public ResponseEntity update(@PathVariable int deskId, @RequestBody DeskDao serviceQueueDesk) {
        try {
            serviceQueueDesk.setDeskId(deskId);
            if (serviceQueueDeskRepository.update(serviceQueueDesk)) {
                return ResponseEntity.ok().body(serviceQueueDesk);
            }
            else {
                return ResponseEntity.status(404).build();
            }
        } catch (Exception exception) {
            return ResponseEntity.status(500).build();
        }
    }

}

