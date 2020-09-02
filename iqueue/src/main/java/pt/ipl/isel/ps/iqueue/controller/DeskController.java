package pt.ipl.isel.ps.iqueue.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pt.ipl.isel.ps.iqueue.dao.DeskDao;
import pt.ipl.isel.ps.iqueue.mapping.DeskDaoModelMapper;
import pt.ipl.isel.ps.iqueue.model.Desk;
import pt.ipl.isel.ps.iqueue.repository.DeskRepository;
import pt.ipl.isel.ps.iqueue.repository.DeskUserRepository;
import pt.ipl.isel.ps.iqueue.utils.ErrorNotificationService;

import javax.transaction.Transactional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/iqueue/desk")
public class DeskController extends Controller<Desk, Integer, DeskDao> {

    @Autowired
    private final DeskRepository deskRepository;

    @Autowired
    private final DeskUserRepository deskUserRepository;

    @Autowired
    private final DeskDaoModelMapper deskDaoModelMapper;

    @Autowired
    private final ErrorNotificationService errorNotificationService;

    public DeskController(DeskRepository deskRepository, DeskUserRepository deskUserRepository, DeskDaoModelMapper deskDaoModelMapper, ErrorNotificationService errorNotificationService) {
        super(deskRepository, deskDaoModelMapper, errorNotificationService);
        this.deskRepository = deskRepository;
        this.deskUserRepository = deskUserRepository;
        this.deskDaoModelMapper = deskDaoModelMapper;
        this.errorNotificationService = errorNotificationService;
    }

    @GetMapping(value = "{deskId}", headers = {"Accept=application/json"})
    public ResponseEntity getById(@PathVariable Integer deskId) {
        return super.getById(deskId);
    }

    @GetMapping(headers = {"Accept=application/json"})
    public ResponseEntity getServiceQueueDesks(@RequestParam(required = false) Integer serviceQueueId) {
        if (serviceQueueId != null) {
            return super.getSome(deskRepository
                    .findAll()
                    .stream()
                    .filter(deskDao -> deskDao.getServiceQueueId() == serviceQueueId)
                    .collect(Collectors.toList())
            );
        } else {
            return super.getAll();
        }
    }

    @PostMapping(headers = {"Accept=application/json", "Content-Type=application/json"})
    public ResponseEntity add(@RequestBody Desk desk) {
        try {
            Desk createdDesk = deskDaoModelMapper.mapDaoToModel(deskRepository
                    .save(deskDaoModelMapper.mapModelToDao(desk)));

            return super.add(createdDesk, "/api/iqueue/desk/" + createdDesk.getDeskId());

        } catch (Exception exception) {
            return ResponseEntity.status(500).build();
        }
    }

    @DeleteMapping(value = "{deskId}")
    @Transactional
    public ResponseEntity remove(@PathVariable int deskId) {
        deskUserRepository.deleteByDeskUserIdsDeskId(deskId);
        return super.remove(deskId);
    }

    @PutMapping(value = "{deskId}")
    public ResponseEntity update(@PathVariable int deskId, @RequestBody Desk desk) {
        desk.setDeskId(deskId);
        return super.update(deskId, desk);
    }

}

