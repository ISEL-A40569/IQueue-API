package pt.ipl.isel.ps.iqueue.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pt.ipl.isel.ps.iqueue.model.AttendanceClassification;
import pt.ipl.isel.ps.iqueue.repository.AttendanceClassificationRepository;

@RestController
public class AttendanceClassificationController {

    @Autowired
    private final AttendanceClassificationRepository attendanceClassificationRepository;

    public AttendanceClassificationController(AttendanceClassificationRepository attendanceClassificationRepository) {
        this.attendanceClassificationRepository = attendanceClassificationRepository;
    }

    @GetMapping(value = "/api/iqueue/attendance/{attendanceId}/classification", headers = {"Accept=application/json"})
    public ResponseEntity getById(@PathVariable int attendanceId) {
        try {
            return ResponseEntity.ok(attendanceClassificationRepository.getById(attendanceId));
        } catch (EmptyResultDataAccessException emptyResultDataAccessException) {
            return ResponseEntity.status(404).build();
        }
        catch (Exception exception) {
            return ResponseEntity.status(500).build();
        }
    }

    @GetMapping(value = "/api/iqueue/attendance/classification", headers = {"Accept=application/json"})
    public ResponseEntity getAll() {
        try {
            return ResponseEntity.ok(attendanceClassificationRepository.getAll());
        } catch (EmptyResultDataAccessException emptyResultDataAccessException) {
            return ResponseEntity.status(404).build();
        }
        catch (Exception exception) {
            return ResponseEntity.status(500).build();
        }
    }

    @PostMapping(value = "/api/iqueue/attendance/classification", headers = {"Accept=application/json", "Content-Type=application/json"})
    public ResponseEntity add(@RequestBody AttendanceClassification attendanceClassification) {
        try {
            if (attendanceClassificationRepository.add(attendanceClassification) != 0) {
                return ResponseEntity
                        .status(201)
                        .header("Location","/api/iqueue/attendance/" + attendanceClassification.getAttendanceId()
                                + "/classification")
                        .body(attendanceClassification);
            }
            else {
                return ResponseEntity.status(409).build();
            }
        } catch (Exception exception) {
            return ResponseEntity.status(500).build();
        }
    }

    @DeleteMapping(value = "/api/iqueue/attendance/{attendanceId}/classification")
    public ResponseEntity remove(@PathVariable int attendanceId) {
        try {
            if (attendanceClassificationRepository.remove(attendanceId)) {
                return ResponseEntity.ok().build();
            }
            else {
                return ResponseEntity.status(404).build();
            }
        } catch (Exception exception) {
            return ResponseEntity.status(500).build();
        }
    }

}
