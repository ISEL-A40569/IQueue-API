package pt.ipl.isel.ps.iqueue.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pt.ipl.isel.ps.iqueue.dao.UserProfileDao;
import pt.ipl.isel.ps.iqueue.dao.embeddable.UserProfileIds;
import pt.ipl.isel.ps.iqueue.mapping.DaoModelMapper;
import pt.ipl.isel.ps.iqueue.model.UserProfile;
import pt.ipl.isel.ps.iqueue.repository.UserProfileRepository;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/iqueue/userprofile")
public class UserProfileController extends Controller<UserProfile, UserProfileIds, UserProfileDao> {

    @Autowired
    private final UserProfileRepository userProfileRepository;
    private final DaoModelMapper<UserProfileDao, UserProfile> daoModelMapper;

    public UserProfileController(UserProfileRepository userProfileRepository, DaoModelMapper<UserProfileDao, UserProfile> daoModelMapper) {
        super(userProfileRepository, daoModelMapper);
        this.userProfileRepository = userProfileRepository;
        this.daoModelMapper = daoModelMapper;
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
                .filter(userProfile -> userProfile.getUserProfileIds().getLanguageId() == languageId)
                .collect(Collectors.toList())
        );
    }

    @Override
    @PostMapping(headers = {"Accept=application/json", "Content-Type=application/json"})
    protected ResponseEntity add(@RequestBody UserProfile userProfile) {
        UserProfile createdUserProfile = daoModelMapper.mapDtoToModel(userProfileRepository.
                save(daoModelMapper.mapModelToDto(userProfile)));

        return super.add(createdUserProfile, "/api/iqueue/userprofile/" + createdUserProfile
                .getUserProfileId());
    }

    @DeleteMapping(value = "{userProfileId}")
    public ResponseEntity remove(@PathVariable int userProfileId, @RequestParam int languageId) {
        return super.remove(new UserProfileIds(userProfileId, languageId));
    }

    @PutMapping(value = "{userProfileId}", headers = {"Accept=application/json", "Content-Type=application/json"})
    public ResponseEntity update(@PathVariable int userProfileId, @RequestParam int languageId, @RequestBody UserProfile newUserProfile) {
        return super.update(new UserProfileIds(userProfileId, languageId), newUserProfile);
    }

    private UserProfileIds buildKeyObject(int userProfileId, int languageId) {
        return new UserProfileIds(userProfileId, languageId);
    }

}
