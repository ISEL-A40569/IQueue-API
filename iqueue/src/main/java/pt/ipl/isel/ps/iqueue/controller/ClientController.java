package pt.ipl.isel.ps.iqueue.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pt.ipl.isel.ps.iqueue.model.Client;
import pt.ipl.isel.ps.iqueue.repository.ClientRepository;


@RestController
@RequestMapping("/api/iqueue/client")
public class ClientController {

    @Autowired
    private final ClientRepository clientRepository;

    public ClientController(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @GetMapping(value = "{clientId}", headers = {"Accept=application/json"})
    public ResponseEntity getById(@PathVariable int clientId) {
        try {
            return ResponseEntity.ok(clientRepository.getById(clientId));
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
            return ResponseEntity.ok(clientRepository.getAll());
        } catch (EmptyResultDataAccessException emptyResultDataAccessException) {
            return ResponseEntity.status(404).build();
        }
        catch (Exception exception) {
            return ResponseEntity.status(500).build();
        }
    }

    @PostMapping(headers = {"Accept=application/json", "Content-Type=application/json"})
    public ResponseEntity add(@RequestBody Client client) {
        try {
            int insertedId = clientRepository.add(client);
            if (insertedId != 0) {
                client.setClientId(insertedId);
                return ResponseEntity
                        .status(201)
                        .header("Location", "/api/iqueue/client/" + insertedId)
                        .body(client);
            }
            else {
                return ResponseEntity.status(409).build();
            }
        } catch (Exception exception) {
            return ResponseEntity.status(500).build();
        }    }

    @DeleteMapping(value = "{clientId}")
    public ResponseEntity remove(@PathVariable int clientId) {
        try {
            if (clientRepository.remove(clientId)) {
                return ResponseEntity.ok().build();
            }
            else {
                return ResponseEntity.status(404).build();
            }
        } catch (Exception exception) {
            return ResponseEntity.status(500).build();
        }
    }

    @PutMapping(value = "{clientId}", headers = {"Accept=application/json", "Content-Type=application/json"})
    public ResponseEntity update(@PathVariable int clientId, @RequestBody Client client) {
        client.setClientId(clientId);
        try {
            if (clientRepository.update(client)) {
                return ResponseEntity.ok().body(client);
            }
            else {
                return ResponseEntity.status(404).build();
            }
        } catch (Exception exception) {
            return ResponseEntity.status(500).build();
        }    }

}
