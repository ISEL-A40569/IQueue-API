package pt.ipl.isel.ps.iqueue.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pt.ipl.isel.ps.iqueue.model.ServiceQueueDesk;
import pt.ipl.isel.ps.iqueue.repository.ServiceQueueDeskRepository;

@RestController
public class ServiceQueueDeskController {

    @Autowired
    final private ServiceQueueDeskRepository serviceQueueDeskRepository;

    public ServiceQueueDeskController(ServiceQueueDeskRepository serviceQueueDeskRepository) {
        this.serviceQueueDeskRepository = serviceQueueDeskRepository;
    }

    @GetMapping(value = "/api/iqueue/operator/{operadorId}/servicequeue/{serviceQueueId}/desk", headers = {"Accept=application/json"})
    public ResponseEntity getServiceQueueDesks(@PathVariable int operadorId, @PathVariable int serviceQueueId) {
        try {
            return ResponseEntity.ok(serviceQueueDeskRepository.getServiceQueueDesks(operadorId, serviceQueueId));
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
    public ResponseEntity add(@RequestBody ServiceQueueDesk serviceQueueDesk) {
        try {
            if (serviceQueueDeskRepository.add(serviceQueueDesk)) {
                return ResponseEntity
                        .status(201)
//                        .header("Location", "/api/iqueue/operator/" + serviceQueueDesk.getOperatorId() +
//                                "/servicequeue/" + serviceQueueDesk.getServiceQueueId() +
//                                "/desk/" + serviceQueueDesk.getDeskId())
                        .build();
            }
            else {
                return ResponseEntity.status(409).build();
            }
        } catch (Exception exception) {
            return ResponseEntity.status(500).build();
        }
    }

    @DeleteMapping(value = "/api/iqueue/operator/{operadorId}/servicequeue/{serviceQueueId}/desk")
    public ResponseEntity remove(@PathVariable int operadorId, @PathVariable int serviceQueueId,
                                 @PathVariable int deskId) {
        try {
            if (serviceQueueDeskRepository.remove(operadorId, serviceQueueId, deskId)) {
                return ResponseEntity.ok().build();
            }
            else {
                return ResponseEntity.status(404).build();
            }
        } catch (Exception exception) {
            return ResponseEntity.status(500).build();
        }
    }
}

