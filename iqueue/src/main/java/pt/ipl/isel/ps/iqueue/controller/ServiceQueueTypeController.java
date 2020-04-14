package pt.ipl.isel.ps.iqueue.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pt.ipl.isel.ps.iqueue.model.ServiceQueueType;
import pt.ipl.isel.ps.iqueue.repository.ServiceQueueTypeRepository;

@RestController
@RequestMapping("/api/iqueue/servicequeuetype")
public class ServiceQueueTypeController {

    @Autowired
    final private ServiceQueueTypeRepository serviceQueueTypeRepository;

    public ServiceQueueTypeController(ServiceQueueTypeRepository serviceQueueTypeRepository) {
        this.serviceQueueTypeRepository = serviceQueueTypeRepository;
    }

    @GetMapping(value = "{serviceQueueTypeId}", headers = {"Accept=application/json"})
    public ResponseEntity getByIds(@PathVariable int serviceQueueTypeId, @RequestParam int languageId) {
        try {
            return ResponseEntity.ok(serviceQueueTypeRepository.getByIds(serviceQueueTypeId, languageId));
        } catch (EmptyResultDataAccessException emptyResultDataAccessException) {
            return ResponseEntity.status(404).build();
        }
        catch (Exception exception) {
            return ResponseEntity.status(500).build();
        }
    }

    @GetMapping(headers = {"Accept=application/json"})
    public ResponseEntity getAll(@RequestParam int languageId) {
        try {
            return ResponseEntity.ok(serviceQueueTypeRepository.getAll(languageId));
        } catch (EmptyResultDataAccessException emptyResultDataAccessException) {
            return ResponseEntity.status(404).build();
        }
        catch (Exception exception) {
            return ResponseEntity.status(500).build();
        }
    }

    @PostMapping(headers = {"Accept=application/json", "Content-Type=application/json"})
    public ResponseEntity add(@RequestBody ServiceQueueType serviceQueueType) {
        try {
            if (serviceQueueTypeRepository.add(serviceQueueType) != 0) {
                return ResponseEntity
                        .status(201)
                        .header("Location", "/api/iqueue/servicequeuetype/" + serviceQueueType.getServiceQueueTypeId())
                        .body(serviceQueueType);
            }
            else {
                return ResponseEntity.status(409).build();
            }
        } catch (Exception exception) {
            return ResponseEntity.status(500).build();
        }
    }

    @DeleteMapping(value = "{serviceQueueTypeId}")
    public ResponseEntity remove(@PathVariable int serviceQueueTypeId,  @RequestParam int languageId) {
        try {
            if (serviceQueueTypeRepository.remove(serviceQueueTypeId, languageId)) {
                return ResponseEntity.ok().build();
            }
            else {
                return ResponseEntity.status(404).build();
            }
        } catch (Exception exception) {
            return ResponseEntity.status(500).build();
        }
    }

    @PutMapping(value = "{serviceQueueTypeId}", headers = {"Accept=application/json", "Content-Type=application/json"})
    public ResponseEntity update(@PathVariable int serviceQueueTypeId, @RequestBody ServiceQueueType serviceQueueType) {
        serviceQueueType.setServiceQueueTypeId(serviceQueueTypeId);
        try {
            if (serviceQueueTypeRepository.update(serviceQueueType)) {
                return ResponseEntity.ok().body(serviceQueueType);
            }
            else {
                return ResponseEntity.status(404).build();
            }
        } catch (Exception exception) {
            return ResponseEntity.status(500).build();
        }
    }
}
