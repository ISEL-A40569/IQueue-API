package pt.ipl.isel.ps.iqueue.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pt.ipl.isel.ps.iqueue.dao.AttendanceClassificationDao;
import pt.ipl.isel.ps.iqueue.mapping.AttendanceClassificationDaoModelMapper;
import pt.ipl.isel.ps.iqueue.model.AttendanceClassification;
import pt.ipl.isel.ps.iqueue.repository.AttendanceClassificationRepository;
import pt.ipl.isel.ps.iqueue.utils.ErrorNotificationService;

@RestController
@RequestMapping("/api/iqueue/attendance")
public class AttendanceClassificationController extends Controller<AttendanceClassification, Integer, AttendanceClassificationDao> {

    @Autowired
    private final AttendanceClassificationRepository attendanceClassificationRepository;

    @Autowired
    private final AttendanceClassificationDaoModelMapper attendanceClassificationDaoModelMapper;

    @Autowired
    private final ErrorNotificationService errorNotificationService;

    public AttendanceClassificationController(AttendanceClassificationRepository attendanceClassificationRepository, AttendanceClassificationDaoModelMapper attendanceClassificationDaoModelMapper, ErrorNotificationService errorNotificationService) {
        super(attendanceClassificationRepository, attendanceClassificationDaoModelMapper, errorNotificationService);
        this.attendanceClassificationRepository = attendanceClassificationRepository;
        this.attendanceClassificationDaoModelMapper = attendanceClassificationDaoModelMapper;
        this.errorNotificationService = errorNotificationService;
    }

    @GetMapping(value = "{attendanceId}/classification", headers = {"Accept=application/json"})
    public ResponseEntity getById(@PathVariable int attendanceId) {
        return super.getById(attendanceId);
    }

    @GetMapping(value = "classification", headers = {"Accept=application/json"})
    public ResponseEntity getAll() {
        return super.getAll();
    }

    @PostMapping(value = "classification", headers = {"Accept=application/json", "Content-Type=application/json"})
    public ResponseEntity add(@RequestBody AttendanceClassification attendanceClassification) {
        try {
            attendanceClassificationRepository.save(attendanceClassificationDaoModelMapper.mapModelToDao(attendanceClassification));

            return super.add(attendanceClassification, "/api/iqueue/attendance/" +
                    attendanceClassification.getAttendanceId() + "/classification");
        } catch (Exception exception) {
            return ResponseEntity.status(500).build();
        }
    }

    @DeleteMapping(value = "{attendanceId}/classification")
    public ResponseEntity remove(@PathVariable int attendanceId) {
        return super.remove(attendanceId);
    }

}
