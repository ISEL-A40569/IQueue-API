package pt.ipl.isel.ps.iqueue.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pt.ipl.isel.ps.iqueue.model.UserProfile;
import pt.ipl.isel.ps.iqueue.repository.UserProfileRepository;

@RestController
@RequestMapping("/api/iqueue/userprofile")
public class UserProfileController {

    @Autowired
    private final UserProfileRepository userProfileRepository;

    public UserProfileController(UserProfileRepository userProfileRepository) {
        this.userProfileRepository = userProfileRepository;
    }

    @GetMapping(value = "{userProfileId}", headers = {"Accept=application/json"})
    public ResponseEntity getByIds(@PathVariable int userProfileId, @RequestParam int languageId) {
        try {
            return ResponseEntity.ok(userProfileRepository.getByIds(userProfileId, languageId));
        } catch (EmptyResultDataAccessException emptyResultDataAccessException) {
            return ResponseEntity.status(404).build();
        }
        catch (Exception exception) {
            return ResponseEntity.status(500).build();
        }
    }
    @GetMapping(headers = {"Accept=application/json"})
    public ResponseEntity getAll(@RequestParam int languageId) {
        try {
            return ResponseEntity.ok(userProfileRepository.getAll(languageId));
        } catch (EmptyResultDataAccessException emptyResultDataAccessException) {
            return ResponseEntity.status(404).build();
        }
        catch (Exception exception) {
            return ResponseEntity.status(500).build();
        }
    }

    @PostMapping(headers = {"Accept=application/json", "Content-Type=application/json"})
    public ResponseEntity add(@RequestBody UserProfile userProfile) {
        try {
            if (userProfileRepository.add(userProfile)) {
                return ResponseEntity
                        .status(201)
                        .header("Location", "/api/iqueue/userprofile/" + userProfile.getUserProfileId())
                        .build();
            }
            else {
                return ResponseEntity.status(409).build();
            }
        } catch (Exception exception) {
            return ResponseEntity.status(500).build();
        }
    }

    @DeleteMapping(value = "{userProfileId}")
    public ResponseEntity remove(@PathVariable int userProfileId,  @RequestParam int languageId) {
        try {
            if (userProfileRepository.remove(userProfileId, languageId)) {
                return ResponseEntity.ok().build();
            }
            else {
                return ResponseEntity.status(404).build();
            }
        } catch (Exception exception) {
            return ResponseEntity.status(500).build();
        }
    }

    @PutMapping(value = "{userProfileId}", headers = {"Accept=application/json", "Content-Type=application/json"})
    public ResponseEntity update(@RequestBody UserProfile userProfile) {
        try {
            if (userProfileRepository.update(userProfile)) {
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
