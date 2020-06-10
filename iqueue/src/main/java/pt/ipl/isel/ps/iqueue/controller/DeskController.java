package pt.ipl.isel.ps.iqueue.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pt.ipl.isel.ps.iqueue.dao.DeskDao;
import pt.ipl.isel.ps.iqueue.mapping.DeskDaoModelMapper;
import pt.ipl.isel.ps.iqueue.model.Desk;
import pt.ipl.isel.ps.iqueue.repository.DeskRepository;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/iqueue/desk")
public class DeskController extends Controller<Desk, Integer, DeskDao> {

    @Autowired
    private final DeskRepository deskRepository;

    @Autowired
    private final DeskDaoModelMapper deskDaoModelMapper;

    public DeskController(DeskRepository deskRepository, DeskDaoModelMapper deskDaoModelMapper) {
        super(deskRepository, deskDaoModelMapper);
        this.deskRepository = deskRepository;
        this.deskDaoModelMapper = deskDaoModelMapper;
    }

    @GetMapping(value = "{deskId}", headers = {"Accept=application/json"})
    public ResponseEntity getById(@PathVariable Integer deskId) {
        return super.getById(deskId);
    }

    @GetMapping(headers = {"Accept=application/json"})
    public ResponseEntity getServiceQueueDesks(@RequestParam int serviceQueueId) {
        return super.getSome(deskRepository
                .findAll()
                .stream()
                .filter(deskDao -> deskDao.getServiceQueueId() == serviceQueueId)
                .collect(Collectors.toList())
        );
    }

    @PostMapping(headers = {"Accept=application/json", "Content-Type=application/json"})
    public ResponseEntity add(@RequestBody Desk desk) {
        try {
            Desk createdDesk = deskDaoModelMapper.mapDaoToModel(deskRepository
                    .save(deskDaoModelMapper.mapModelToDao(desk)));

            return super.add(desk, "/api/iqueue/desk/" + createdDesk.getDeskId());

        } catch (Exception exception) {
            return ResponseEntity.status(500).build();
        }
    }

    @DeleteMapping(value = "{deskId}")
    public ResponseEntity remove(@PathVariable int deskId) {
        return super.remove(deskId);
    }

    @PutMapping(value = "/api/iqueue/operator/servicequeue/desk/{deskId}")
    public ResponseEntity update(@PathVariable int deskId, @RequestBody Desk desk) {
        return super.update(deskId, desk);
    }

}

