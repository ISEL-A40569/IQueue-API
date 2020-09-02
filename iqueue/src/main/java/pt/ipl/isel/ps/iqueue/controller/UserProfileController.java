package pt.ipl.isel.ps.iqueue.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pt.ipl.isel.ps.iqueue.dao.UserProfileDao;
import pt.ipl.isel.ps.iqueue.dao.embeddable.UserProfileIds;
import pt.ipl.isel.ps.iqueue.mapping.UserProfileDaoModelMapper;
import pt.ipl.isel.ps.iqueue.model.UserProfile;
import pt.ipl.isel.ps.iqueue.repository.UserProfileRepository;
import pt.ipl.isel.ps.iqueue.utils.ErrorNotificationService;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/iqueue/userprofile")
public class UserProfileController extends Controller<UserProfile, UserProfileIds, UserProfileDao> {

    @Autowired
    private final UserProfileRepository userProfileRepository;

    @Autowired
    private final UserProfileDaoModelMapper userProfileDaoModelMapper;

    @Autowired
    private final ErrorNotificationService errorNotificationService;

    public UserProfileController(UserProfileRepository userProfileRepository, UserProfileDaoModelMapper userProfileDaoModelMapper, ErrorNotificationService errorNotificationService) {
        super(userProfileRepository, userProfileDaoModelMapper, errorNotificationService);
        this.userProfileRepository = userProfileRepository;
        this.userProfileDaoModelMapper = userProfileDaoModelMapper;
        this.errorNotificationService = errorNotificationService;
    }

    @GetMapping(value = "{userProfileId}", headers = {"Accept=application/json"})
    public ResponseEntity getByIds(@PathVariable int userProfileId, @RequestParam int languageId) {
        return super.getById(buildKeyObject(userProfileId, languageId));
    }

    @GetMapping(headers = {"Accept=application/json"})
    public ResponseEntity getByLanguage(@RequestParam int languageId) {
        return super.getSome(userProfileRepository
                .findAll()
                .stream()
                .filter(userProfileDao -> userProfileDao.getUserProfileIds().getLanguageId() == languageId)
                .collect(Collectors.toList())
        );
    }

    @PostMapping(headers = {"Accept=application/json", "Content-Type=application/json"})
    protected ResponseEntity add(@RequestBody UserProfile userProfile) {
        try {
            userProfileRepository.save(userProfileDaoModelMapper.mapModelToDao(userProfile));

            return super.add(userProfile, "/api/iqueue/userprofile/" + userProfile
                    .getUserProfileId());

        } catch (Exception exception) {
            return ResponseEntity.status(500).build();
        }
    }

    @DeleteMapping(value = "{userProfileId}")
    public ResponseEntity remove(@PathVariable int userProfileId, @RequestParam int languageId) {
        return super.remove(new UserProfileIds(userProfileId, languageId));
    }

    @PutMapping(value = "{userProfileId}", headers = {"Accept=application/json", "Content-Type=application/json"})
    public ResponseEntity update(@PathVariable int userProfileId, @RequestBody UserProfile newUserProfile) {
        newUserProfile.setUserProfileId(userProfileId);
        return super.update(new UserProfileIds(userProfileId, newUserProfile.getLanguageId()), newUserProfile);
    }

    private UserProfileIds buildKeyObject(int userProfileId, int languageId) {
        return new UserProfileIds(userProfileId, languageId);
    }

}
