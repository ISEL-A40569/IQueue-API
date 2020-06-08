package pt.ipl.isel.ps.iqueue.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import pt.ipl.isel.ps.iqueue.dao.UserDao;
import pt.ipl.isel.ps.iqueue.repository.rowmapper.UserRowMapper;

@Component
public interface UserRepository extends JpaRepository<UserDao, Integer> {

//    @Autowired
//    private final JdbcTemplate jdbcTemplate;
//
//    @Autowired
//    private final RowMapper<User> userRowMapper;
//
//    private final String getQueryTemplate = "exec SelectUser ?";
//
//    public UserRepository(JdbcTemplate jdbcTemplate, UserRowMapper userRowMapper) {
//        this.jdbcTemplate = jdbcTemplate;
//        this.userRowMapper = userRowMapper;
//    }
//
//    public User getById(int userId) {
//        return jdbcTemplate.queryForObject(getQueryTemplate, new Object[]{userId}, userRowMapper);
//    }
//
//    public List<User> getAll() {
//        return jdbcTemplate.query(getQueryTemplate, new Object[]{null}, userRowMapper);
//    }
//
//    public int add(User user) {
//        String insertQueryTemplate = "exec InsertUser ?, ?, ?, ?, ?";
//        return jdbcTemplate.queryForObject(insertQueryTemplate, new Object[]{user.getUserName(),
//                user.getEmail(), user.getPhoneNumber(), user.getAddress(),
//                user.getUserProfileId()}, Integer.class);
//    }
//
//    public boolean remove(int userId) {
//        String removeQueryTemplate = "exec DeleteUser ?";
//        return jdbcTemplate.update(removeQueryTemplate, userId) == 1;
//    }
//
//    public boolean update(User user) {
//        String updateQueryTemplate = "exec UpdateUser ?, ?, ?, ?, ?, ?";
//
//        return jdbcTemplate.update(updateQueryTemplate, user.getUserId(),
//                user.getUserName(), user.getEmail(), user.getPhoneNumber(),
//                user.getAddress(), user.getUserProfileId()) == 1;
//    }
}
