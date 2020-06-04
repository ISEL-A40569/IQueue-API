package pt.ipl.isel.ps.iqueue.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pt.ipl.isel.ps.iqueue.model.UserProfile;
import pt.ipl.isel.ps.iqueue.repository.UserProfileRepository;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/iqueue/userprofile")
public class UserProfileController extends Controller<UserProfile> {

    @Autowired
    private final UserProfileRepository userProfileRepository;

    public UserProfileController(UserProfileRepository userProfileRepository) {
        super(userProfileRepository);
        this.userProfileRepository = userProfileRepository;
    }

    @GetMapping(value = "{userProfileId}", headers = {"Accept=application/json"})
    public ResponseEntity getByIds(@PathVariable int userProfileId, @RequestParam int languageId) {
        return super.getSome(userProfileRepository
                .findAll()
                .stream()
                .filter(userProfile -> userProfile.getUserProfileIds().getUserProfileId() == userProfileId
                        && userProfile.getUserProfileIds().getLanguageId() == languageId)
//                .distinct() // TODO: this shouldn't be necessary, verify why there are duplicates
                .collect(Collectors.toList())
        );
    }

    @GetMapping(headers = {"Accept=application/json"})
    public ResponseEntity getAll(@RequestParam int languageId) {
        return super.getSome(userProfileRepository
                .findAll()
                .stream()
                .filter(userProfile -> userProfile.getUserProfileIds().getLanguageId() == languageId)
//                .distinct() // TODO: this shouldn't be necessary, verify why there are duplicates
                .collect(Collectors.toList())
        );
    }

    @PostMapping(headers = {"Accept=application/json", "Content-Type=application/json"})
    public ResponseEntity add(@RequestBody UserProfile userProfile) {
        UserProfile createdUserProfile = userProfileRepository.save(userProfile);
        return super.add(createdUserProfile, "/api/iqueue/userprofile/" + createdUserProfile
                .getUserProfileIds().getUserProfileId());
    }

    @DeleteMapping(value = "{userProfileId}")
    public ResponseEntity remove(@PathVariable int userProfileId, @RequestParam int languageId) {
        return super.remove(userProfileRepository
                .findAll()
                .stream()
                .filter(userProfile -> userProfile.getUserProfileIds().getUserProfileId() == userProfileId
                        && userProfile.getUserProfileIds().getLanguageId() == languageId)
                .findFirst()
        );
    }

    @PutMapping(value = "{userProfileId}", headers = {"Accept=application/json", "Content-Type=application/json"})
    public ResponseEntity update(@PathVariable int userProfileId, @RequestBody UserProfile newUserProfile) {
        return super.update(userProfileRepository
                        .findAll()
                        .stream()
                        .filter(userProfile -> userProfile.getUserProfileIds().getUserProfileId() == userProfileId
                                && userProfile.getUserProfileIds().getLanguageId() == userProfile.getUserProfileIds().getLanguageId())
                        .findFirst(),
                newUserProfile);
    }

}
