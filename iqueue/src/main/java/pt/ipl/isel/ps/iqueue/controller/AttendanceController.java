package pt.ipl.isel.ps.iqueue.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pt.ipl.isel.ps.iqueue.dao.AttendanceDao;
import pt.ipl.isel.ps.iqueue.repository.AttendanceRepository;

@RestController
@RequestMapping("/api/iqueue/attendance")
public class AttendanceController {

    @Autowired
    private final AttendanceRepository attendanceRepository;

    public AttendanceController(AttendanceRepository attendanceRepository) {
        this.attendanceRepository = attendanceRepository;
    }

    @GetMapping(value = "{attendanceId}", headers = {"Accept=application/json"})
    public ResponseEntity getById(@PathVariable int attendanceId) {
        try {
            return ResponseEntity.ok(attendanceRepository.getById(attendanceId));
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
            return ResponseEntity.ok(attendanceRepository.getAll());
        } catch (EmptyResultDataAccessException emptyResultDataAccessException) {
            return ResponseEntity.status(404).build();
        }
        catch (Exception exception) {
            return ResponseEntity.status(500).build();
        }
    }

    @PostMapping(headers = {"Accept=application/json", "Content-Type=application/json"})
    public ResponseEntity add(@RequestBody AttendanceDao attendance) {
        try {
            int insertedId = attendanceRepository.add(attendance);
            if (insertedId != 0) {
                attendance.setAttendanceId(insertedId);
                return ResponseEntity
                        .status(201)
                        .header("Location", "/api/iqueue/attendance/" + insertedId)
                        .body(attendance);
            }
            else {
                return ResponseEntity.status(409).build();
            }
        } catch (Exception exception) {
            return ResponseEntity.status(500).build();
        }
    }

    @DeleteMapping(value = "{attendanceId}")
    public ResponseEntity remove(@PathVariable int attendanceId) {
        try {
            if (attendanceRepository.remove(attendanceId)) {
                return ResponseEntity.ok().build();
            }
            else {
                return ResponseEntity.status(404).build();
            }
        } catch (Exception exception) {
            return ResponseEntity.status(500).build();
        }
    }

    @PutMapping(value = "{attendanceId}", headers = {"Accept=application/json", "Content-Type=application/json"})
    public ResponseEntity update(@PathVariable int attendanceId, @RequestBody AttendanceDao attendance) {
        attendance.setAttendanceId(attendanceId);
        try {
            if (attendanceRepository.update(attendance)) {
                return ResponseEntity.ok().body(attendance);
            }
            else {
                return ResponseEntity.status(404).build();
            }
        } catch (Exception exception) {
            return ResponseEntity.status(500).build();
        }
    }
}
