package pt.ipl.isel.ps.iqueue.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pt.ipl.isel.ps.iqueue.model.Client;
import pt.ipl.isel.ps.iqueue.repository.ClientRepository;


@RestController
@RequestMapping("/api/iqueue/client")
public class ClientController extends Controller<Client> {

    public ClientController(ClientRepository clientRepository) {
        super(clientRepository);
    }

    @GetMapping(value = "{clientId}", headers = {"Accept=application/json"})
    public ResponseEntity getById(@PathVariable int clientId) {
        return super.getById(clientId);
    }

    @GetMapping(headers = {"Accept=application/json"})
    public ResponseEntity getAll() {
        return super.getAll();
    }

    @PostMapping(headers = {"Accept=application/json", "Content-Type=application/json"})
    public ResponseEntity add(@RequestBody Client client) {
        return super.add(client, "/api/iqueue/client");
    }

    @DeleteMapping(value = "{clientId}")
    public ResponseEntity remove(@PathVariable int clientId) {
        return super.remove(clientId);
    }

    @PutMapping(value = "{clientId}", headers = {"Accept=application/json", "Content-Type=application/json"})
    public ResponseEntity update(@PathVariable int clientId, @RequestBody Client client) {
        client.setClientId(clientId);
        return super.update(client);
    }

}
