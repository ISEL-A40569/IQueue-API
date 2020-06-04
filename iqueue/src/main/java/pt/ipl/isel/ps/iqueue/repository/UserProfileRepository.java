package pt.ipl.isel.ps.iqueue.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import pt.ipl.isel.ps.iqueue.model.UserProfile;

@Component
public interface UserProfileRepository extends JpaRepository<UserProfile, Integer> {


//    @Autowired
//    private final JdbcTemplate jdbcTemplate;
//
//    @Autowired
//    private final RowMapper<UserProfile> userProfileRowMapper;
//
//    private final String getQueryTemplate = "exec SelectUserProfile ?, ?";
//
//    public UserProfileRepository(JdbcTemplate jdbcTemplate, RowMapper<UserProfile> userProfileRowMapper) {
//        this.jdbcTemplate = jdbcTemplate;
//        this.userProfileRowMapper = userProfileRowMapper;
//    }
//
//    public UserProfile getByIds(int userProfileId, int languageId) {
//        return jdbcTemplate.queryForObject(getQueryTemplate, new Object[]{userProfileId, languageId}, userProfileRowMapper);
//    }
//
//    public List<UserProfile> getAll(int languageId) {
//        return jdbcTemplate.query(getQueryTemplate, new Object[]{null, languageId}, userProfileRowMapper);
//    }
//
//    public boolean add(UserProfile userProfile) {
//        String insertQueryTemplate = "exec InsertUserProfile ?, ?, ?";
//
//        return jdbcTemplate.update(insertQueryTemplate, userProfile.getUserProfileId(),
//                userProfile.getLanguageId(), userProfile.getUserProfileDescription()) == 1;
//    }
//
//    public boolean remove(int userProfileId, int languageId) {
//        String deleteQueryTemplate = "exec DeleteUserProfile ?, ?";
//        return jdbcTemplate.update(deleteQueryTemplate, userProfileId, languageId) > 0;
//    }
//    public boolean update(UserProfile userProfile) {
//        String updateQueryTemplate = "exec UpdateUserProfile ?, ?, ?";
//        return jdbcTemplate.update(updateQueryTemplate, userProfile.getUserProfileId(),
//                userProfile.getLanguageId(), userProfile.getUserProfileDescription()) == 1;
//    }

}
