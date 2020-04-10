package pt.ipl.isel.ps.iqueue.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pt.ipl.isel.ps.iqueue.model.Attendance;
import pt.ipl.isel.ps.iqueue.repository.AttendanceRepository;

@RestController
@RequestMapping("/api/iqueue/attendance")
public class AttendanceController extends Controller<Attendance> {

    public AttendanceController(AttendanceRepository attendanceRepository) {
        super(attendanceRepository);
    }

    @GetMapping(value = "{attendanceId}", headers = {"Accept=application/json"})
    public ResponseEntity getById(@PathVariable int attendanceId) {
        return super.getById(attendanceId);
    }

    @GetMapping(headers = {"Accept=application/json"})
    public ResponseEntity getAll() {
        return super.getAll();
    }

    @PostMapping(headers = {"Accept=application/json", "Content-Type=application/json"})
    public ResponseEntity add(@RequestBody  Attendance attendance) {
        return super.add(attendance);
    }

    @DeleteMapping(value = "{attendanceId}")
    public ResponseEntity remove(@PathVariable int attendanceId) {
        return super.remove(attendanceId);
    }

    @PostMapping(value = "{attendanceId}", headers = {"Accept=application/json", "Content-Type=application/json"})
    public ResponseEntity update(@PathVariable int attendanceId, @RequestBody  Attendance attendance) {
        attendance.setAttendanceId(attendanceId);
        return super.update(attendance);
    }

}
