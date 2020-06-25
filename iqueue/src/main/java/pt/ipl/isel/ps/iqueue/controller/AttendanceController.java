package pt.ipl.isel.ps.iqueue.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pt.ipl.isel.ps.iqueue.dao.AttendanceDao;
import pt.ipl.isel.ps.iqueue.mapping.AttendanceDaoModelMapper;
import pt.ipl.isel.ps.iqueue.model.Attendance;
import pt.ipl.isel.ps.iqueue.repository.AttendanceRepository;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/iqueue/attendance")
public class AttendanceController extends Controller<Attendance, Integer, AttendanceDao> {

    @Autowired
    private final AttendanceRepository attendanceRepository;

    @Autowired
    private final AttendanceDaoModelMapper attendanceDaoModelMapper;

    public AttendanceController(AttendanceRepository attendanceRepository, AttendanceDaoModelMapper attendanceDaoModelMapper) {
        super(attendanceRepository, attendanceDaoModelMapper);
        this.attendanceRepository = attendanceRepository;
        this.attendanceDaoModelMapper = attendanceDaoModelMapper;
    }

    @GetMapping(value = "{attendanceId}", headers = {"Accept=application/json"})
    public ResponseEntity getById(@PathVariable int attendanceId) {
        return super.getById(attendanceId);
    }

    @GetMapping(headers = {"Accept=application/json"})
    public ResponseEntity getAll(@RequestParam Integer serviceQueueId) {    // TODO: THIS IS HORRIBLE, MUST RE-THINK AND RE-WRITE THIS SHIT!!!
        if (serviceQueueId != null) {
            List<AttendanceDao> attendanceDaoList = attendanceRepository
                    .findAll()
                    .stream()
                    .filter(attendanceDao -> attendanceDao.getServiceQueueId() == serviceQueueId &&
                            attendanceDao.getAttendanceStatusId() == 3)
                    .collect(Collectors.toList());
            if (!attendanceDaoList.isEmpty()) {
                return super.getSome(attendanceDaoList);
            } else {
                return ResponseEntity.status(404).build();
            }
        } else {
            return super.getAll();
        }
    }

    @PostMapping(headers = {"Accept=application/json", "Content-Type=application/json"})
    public ResponseEntity add(@RequestBody Attendance attendance) {
        try {
            Attendance createdAttendance = attendanceDaoModelMapper.mapDaoToModel(attendanceRepository
                    .save(attendanceDaoModelMapper.mapModelToDao(attendance)));

            return super.add(createdAttendance, "/api/iqueue/attendance" + createdAttendance.getAttendanceId());

        } catch (Exception exception) {
            return ResponseEntity.status(500).build();
        }
    }

    @DeleteMapping(value = "{attendanceId}")
    public ResponseEntity remove(@PathVariable int attendanceId) {
        return super.remove(attendanceId);
    }

    @PutMapping(value = "{attendanceId}", headers = {"Accept=application/json", "Content-Type=application/json"})
    public ResponseEntity update(@PathVariable int attendanceId, @RequestBody Attendance attendance) {
        attendance.setAttendanceId(attendanceId);
        return super.update(attendanceId, attendance);
    }
}
