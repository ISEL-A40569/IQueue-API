package pt.ipl.isel.ps.iqueue.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pt.ipl.isel.ps.iqueue.dao.AttendanceStatusDao;
import pt.ipl.isel.ps.iqueue.dao.embeddable.AttendanceStatusIds;
import pt.ipl.isel.ps.iqueue.mapping.AttendanceStatusDaoModelMapper;
import pt.ipl.isel.ps.iqueue.model.AttendanceStatus;
import pt.ipl.isel.ps.iqueue.repository.AttendanceStatusRepository;
import pt.ipl.isel.ps.iqueue.utils.ErrorNotificationService;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/iqueue/attendancestatus")
public class AttendanceStatusController extends Controller<AttendanceStatus, AttendanceStatusIds, AttendanceStatusDao> {

    @Autowired
    private final AttendanceStatusRepository attendanceStatusRepository;

    @Autowired
    private final AttendanceStatusDaoModelMapper attendanceStatusDaoModelMapper;

    @Autowired
    private final ErrorNotificationService errorNotificationService;

    public AttendanceStatusController(AttendanceStatusRepository attendanceStatusRepository, AttendanceStatusDaoModelMapper attendanceStatusDaoModelMapper, ErrorNotificationService errorNotificationService) {
        super(attendanceStatusRepository, attendanceStatusDaoModelMapper, errorNotificationService);
        this.attendanceStatusRepository = attendanceStatusRepository;
        this.attendanceStatusDaoModelMapper = attendanceStatusDaoModelMapper;
        this.errorNotificationService = errorNotificationService;
    }

    @GetMapping(value = "{attendanceStatusId}", headers = {"Accept=application/json"})
    public ResponseEntity getById(@PathVariable int attendanceStatusId, @RequestParam int languageId) {
        return super.getById(new AttendanceStatusIds(attendanceStatusId, languageId));
    }

    @GetMapping(headers = {"Accept=application/json"})
    public ResponseEntity getByLanguage(@RequestParam int languageId) {
        return super.getSome(attendanceStatusRepository
                .findAll()
                .stream()
                .filter(attendanceStatusDao -> attendanceStatusDao.getAttendanceStatusIds().getLanguageId() == languageId)
                .collect(Collectors.toList())
        );
    }

    @PostMapping(headers = {"Accept=application/json", "Content-Type=application/json"})
    public ResponseEntity add(@RequestBody AttendanceStatus attendanceStatus) {
        try {
            attendanceStatusRepository.save(attendanceStatusDaoModelMapper.mapModelToDao(attendanceStatus));

            return super.add(attendanceStatus, "/api/iqueue/attendancestatus/" + attendanceStatus.getAttendanceStatusId());
        } catch (Exception exception) {
            errorNotificationService.sendErrorToAdministrators(exception.getMessage());
            return ResponseEntity.status(500).build();
        }
    }

    @DeleteMapping(value = "{attendanceStatusId}")
    public ResponseEntity remove(@PathVariable int attendanceStatusId, @RequestParam int languageId) {
        return super.remove(new AttendanceStatusIds(attendanceStatusId, languageId));
    }

    @PutMapping(value = "{attendanceStatusId}", headers = {"Accept=application/json", "Content-Type=application/json"})
    public ResponseEntity udpate(@PathVariable int attendanceStatusId, @RequestParam int languageId,
                                 @RequestBody AttendanceStatus attendanceStatus) {
        attendanceStatus.setAttendanceStatusId(attendanceStatusId);
        return super.update(new AttendanceStatusIds(attendanceStatusId, languageId), attendanceStatus);
    }
}
