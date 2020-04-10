package pt.ipl.isel.ps.iqueue.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pt.ipl.isel.ps.iqueue.model.ServiceQueueDeskUser;
import pt.ipl.isel.ps.iqueue.repository.ServiceQueueDeskUserRepository;

import java.time.LocalDateTime;

@RestController
//@RequestMapping("")
public class ServiceQueueDeskUserController {

    @Autowired
    final private ServiceQueueDeskUserRepository serviceQueueDeskUserRepository;

    public ServiceQueueDeskUserController(ServiceQueueDeskUserRepository serviceQueueDeskUserRepository) {
        this.serviceQueueDeskUserRepository = serviceQueueDeskUserRepository;
    }

    @GetMapping(value = "/api/iqueue/operator/{operadorId}/servicequeue/{serviceQueueId}/desk/{deskId}/user",
            headers = {"Accept=application/json"})
    public ResponseEntity getDeskUsers(@PathVariable int operadorId, @PathVariable int serviceQueueId,
                                  @PathVariable int deskId, @RequestParam(required = false) LocalDateTime date) {
        try {
            if (date == null) {
                return ResponseEntity.ok(serviceQueueDeskUserRepository.getDeskUsers(operadorId, serviceQueueId, deskId));
            } else {
                return ResponseEntity.ok(serviceQueueDeskUserRepository.getDeskUsersByDate(operadorId, serviceQueueId, deskId, date));
            }
        } catch (EmptyResultDataAccessException emptyResultDataAccessException) {
            return ResponseEntity.status(404).build();
        }
        catch (Exception exception) {
            return ResponseEntity.status(500).build();
        }
    }

    @GetMapping(value = "/api/iqueue/operator/{operadorId}/servicequeue/{serviceQueueId}/desk/{deskId}/user/{userId}",
            headers = {"Accept=application/json"})
    public ResponseEntity getDeskUserDates(@PathVariable int operadorId, @PathVariable int serviceQueueId,
                                       @PathVariable int deskid, @PathVariable int userId) {
        try {
            return ResponseEntity.ok(serviceQueueDeskUserRepository.getDeskUserDates(operadorId, serviceQueueId, deskid, userId));
        } catch (EmptyResultDataAccessException emptyResultDataAccessException) {
            return ResponseEntity.status(404).build();
        }
        catch (Exception exception) {
            return ResponseEntity.status(500).build();
        }
    }

    @GetMapping(value = "/api/iqueue/operator/servicequeue/desk/user/{userId}", headers = {"Accept=application/json"})
    public ResponseEntity getUserDesks(@PathVariable int userId, @RequestParam(required = false) LocalDateTime date) {
        try {
            if (date == null) {
                return ResponseEntity.ok(serviceQueueDeskUserRepository.getUserDesks(userId));
            } else {
                return ResponseEntity.ok(serviceQueueDeskUserRepository.getUserDesksByDate(userId, date));
            }
        } catch (EmptyResultDataAccessException emptyResultDataAccessException) {
            return ResponseEntity.status(404).build();
        }
        catch (Exception exception) {
            return ResponseEntity.status(500).build();
        }
    }

    @PostMapping(value = "/api/iqueue/operator/servicequeue/desk/user", headers = {"Accept=application/json", "Content-Type=application/json"})
    public ResponseEntity add(ServiceQueueDeskUser serviceQueueDeskUser) {
        try {
            if (serviceQueueDeskUserRepository.add(serviceQueueDeskUser)) {
                return ResponseEntity
                        .status(201)
//                        .header("Location", "/api/iqueue/operator/" + serviceQueueDeskUser.getOperatorId() +
//                                "/servicequeue/" + serviceQueueDeskUser.getServiceQueueId() +
//                                "/desk/" + serviceQueueDeskUser.getDeskId() +
//                                "/user/" + serviceQueueDeskUser.getUserId())
                        .build();
            }
            else {
                return ResponseEntity.status(409).build();
            }
        } catch (Exception exception) {
            return ResponseEntity.status(500).build();
        }
    }

    @DeleteMapping("/api/iqueue/operator/{operadorId}/servicequeue/{serviceQueueId}/desk/{deskId}/user/{userId}")
    public ResponseEntity remove(@PathVariable int operadorId, @PathVariable int serviceQueueId, @PathVariable int deskId,
                                       @PathVariable int userId, @RequestParam(required = false) LocalDateTime date) {
        try {
            if (serviceQueueDeskUserRepository.remove(operadorId, serviceQueueId, deskId, userId, date)) {
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
