package pt.ipl.isel.ps.iqueue.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pt.ipl.isel.ps.iqueue.dao.AttendanceStatusDao;
import pt.ipl.isel.ps.iqueue.repository.AttendanceStatusRepository;

@RestController
@RequestMapping("/api/iqueue/attendancestatus")
public class AttendanceStatusController {

    @Autowired
    private final AttendanceStatusRepository attendanceStatusRepository;

    public AttendanceStatusController(AttendanceStatusRepository attendanceStatusRepository) {
        this.attendanceStatusRepository = attendanceStatusRepository;
    }

    @GetMapping(value = "{attendanceStatusId}", headers = {"Accept=application/json"})
    public ResponseEntity getByIds(@PathVariable int attendanceStatusId, @RequestParam int languageId) {
        try {
            return ResponseEntity.ok(attendanceStatusRepository.getByIds(attendanceStatusId, languageId));
        } catch (EmptyResultDataAccessException emptyResultDataAccessException) {
            return ResponseEntity.status(404).build();
        }
        catch (Exception exception) {
            return ResponseEntity.status(500).build();
        }
    }

    @GetMapping(headers = {"Accept=application/json"})
    public ResponseEntity getByLanguage(@RequestParam int languageId) {
        try {
            return ResponseEntity.ok(attendanceStatusRepository.getByLanguage(languageId));
        } catch (EmptyResultDataAccessException emptyResultDataAccessException) {
            return ResponseEntity.status(404).build();
        }
        catch (Exception exception) {
            return ResponseEntity.status(500).build();
        }
    }

    @PostMapping(headers = {"Accept=application/json", "Content-Type=application/json"})
    public ResponseEntity add(@RequestBody AttendanceStatusDao attendanceStatus) {
        try {
            if (attendanceStatusRepository.add(attendanceStatus) != 0) {
                return ResponseEntity
                        .status(201)
                        .header("Location", "/api/iqueue/attendancestatus/" + attendanceStatus.getAttendanceStatusIds())
                        .body(attendanceStatus);
            }
            else {
                return ResponseEntity.status(409).build();
            }
        } catch (Exception exception) {
            return ResponseEntity.status(500).build();
        }
    }

    @DeleteMapping(value = "{attendanceStatusId}")
    public ResponseEntity remove(@PathVariable int attendanceStatusId, @RequestParam int languageId) {
        try {
            if (attendanceStatusRepository.remove(attendanceStatusId, languageId)) {
                return ResponseEntity.ok().build();
            } else {
                return ResponseEntity.status(404).build();
            }
        }
        catch (Exception exception) {
            return ResponseEntity.status(500).build();
        }
    }

    @PutMapping(value = "{attendanceStatusId}", headers = {"Accept=application/json", "Content-Type=application/json"})
    public ResponseEntity udpate(@PathVariable int attendanceStatusId, @RequestParam int languageId,
                                 @RequestBody AttendanceStatusDao attendanceStatus) {
        attendanceStatus.setAttendanceStatusIds(attendanceStatusId);
        attendanceStatus.setLanguageId(languageId);
        try {
            if (attendanceStatusRepository.update(attendanceStatus)) {
                return ResponseEntity.ok().body(attendanceStatus);
            } else {
                return ResponseEntity.status(404).build();
            }
        }
        catch (Exception exception) {
            return ResponseEntity.status(500).build();
        }
    }
}
