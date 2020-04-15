package pt.ipl.isel.ps.iqueue.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pt.ipl.isel.ps.iqueue.model.AttendanceClassification;
import pt.ipl.isel.ps.iqueue.repository.AttendanceClassificationRepository;

@RestController
public class AttendanceClassificationController extends Controller<AttendanceClassification> {

    public AttendanceClassificationController(AttendanceClassificationRepository attendanceClassificationRepository) {
        super(attendanceClassificationRepository);
    }

    @GetMapping(value = "/api/iqueue/attendance/{attendanceId}/classification", headers = {"Accept=application/json"})
    public ResponseEntity getById(@PathVariable int attendanceId) {
        return super.getById(attendanceId);
    }

    @GetMapping(value = "/api/iqueue/attendance/classification", headers = {"Accept=application/json"})
    public ResponseEntity getAll() {
        return super.getAll();
    }

    @PostMapping(value = "/api/iqueue/attendance/classification", headers = {"Accept=application/json", "Content-Type=application/json"})
    public ResponseEntity add(@RequestBody AttendanceClassification attendanceClassification) {
        return super.add(attendanceClassification, "/api/iqueue/attendance/classification");
    }

    // TODO: DELETE function
}
