package pt.ipl.isel.ps.iqueue.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pt.ipl.isel.ps.iqueue.dao.DeskUserDao;
import pt.ipl.isel.ps.iqueue.dao.keys.DeskUserIds;
import pt.ipl.isel.ps.iqueue.mapping.DeskUserDaoModelMapper;
import pt.ipl.isel.ps.iqueue.model.DeskUser;
import pt.ipl.isel.ps.iqueue.repository.DeskUserRepository;
import pt.ipl.isel.ps.iqueue.utils.ErrorNotificationService;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/iqueue/desk")
public class DeskUserController extends Controller<DeskUser, DeskUserIds, DeskUserDao> {

    @Autowired
    private final DeskUserRepository deskUserRepository;

    @Autowired
    private final DeskUserDaoModelMapper deskUserDaoModelMapper;

    @Autowired
    private final ErrorNotificationService errorNotificationService;

    public DeskUserController(DeskUserRepository deskUserRepository, DeskUserDaoModelMapper deskUserDaoModelMapper, ErrorNotificationService errorNotificationService) {
        super(deskUserRepository, deskUserDaoModelMapper, errorNotificationService);
        this.deskUserRepository = deskUserRepository;
        this.deskUserDaoModelMapper = deskUserDaoModelMapper;
        this.errorNotificationService = errorNotificationService;
    }

    @GetMapping(value = "{deskId}/user", headers = {"Accept=application/json"})
    public ResponseEntity getDeskUser(@PathVariable int deskId) {
        return super.getSome(deskUserRepository
                .findAll()
                .stream()
                .filter(deskUserDao -> deskUserDao.getDeskUserIds().getDeskId() == deskId)
                .collect(Collectors.toList())
        );
    }

    @GetMapping(value = "user/{userId}", headers = {"Accept=application/json"})
    public ResponseEntity getUserDesk(@PathVariable int userId) {
        return super.getSome(deskUserRepository
                .findAll()
                .stream()
                .filter(deskUserDao -> deskUserDao.getDeskUserIds().getUserId() == userId)
                .collect(Collectors.toList())
        );
    }

    @PostMapping(value = "user", headers = {"Accept=application/json", "Content-Type=application/json"})
    public ResponseEntity add(@RequestBody DeskUser deskUser) {
        try {
            deskUserRepository.save(deskUserDaoModelMapper.mapModelToDao(deskUser));

            return super.add(deskUser, "/api/iqueue/desk/" + deskUser.getDeskId() +
                    "/user/" + deskUser.getUserId());

        } catch (Exception exception) {
            errorNotificationService.sendErrorToAdministrators(exception.getMessage());
            return ResponseEntity.status(500).build();
        }
    }

    @DeleteMapping("{deskId}/user/{userId}")
    public ResponseEntity remove(@PathVariable int deskId, @PathVariable int userId) {
        return super.remove(new DeskUserIds(deskId, userId));
    }
}
