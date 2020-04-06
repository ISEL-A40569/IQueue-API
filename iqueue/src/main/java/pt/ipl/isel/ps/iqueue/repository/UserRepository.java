package pt.ipl.isel.ps.iqueue.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import pt.ipl.isel.ps.iqueue.model.User;
import pt.ipl.isel.ps.iqueue.repository.rowmapper.UserRowMapper;

import java.util.List;

@Component
public class UserRepository {

    @Autowired
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    private final RowMapper<User> userRowMapper;

    private final String getQueryTemplate = "exec SelectUser ?";

    public UserRepository(JdbcTemplate jdbcTemplate, UserRowMapper userRowMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.userRowMapper = userRowMapper;
    }

    public User getById(int userId) {
        return jdbcTemplate.queryForObject(getQueryTemplate, new Object[]{userId}, userRowMapper);
    }

    public List<User> getAll() {
        return jdbcTemplate.query(getQueryTemplate, new Object[]{null}, userRowMapper);
    }

    public boolean add(User user) {
        String insertQueryTemplate = "exec InsertUser ?, ?, ?, ?, ?";
        return jdbcTemplate.update(insertQueryTemplate, user.getUserName(),
                user.getEmail(), user.getPhoneNumber(), user.getAddress(),
                user.getUserProfileId()) == 1;
    }

    public boolean remove(int userId) {
        String removeQueryTemplate = "exec DeleteUser ?";

        return jdbcTemplate.update(removeQueryTemplate, userId) == 1;
    }

    public boolean update(User user) {
        String updateQueryTemplate = "exec UpdateUser ?, ?, ?, ?, ?, ?";

        return jdbcTemplate.update(updateQueryTemplate, user.getUserProfileId(),
                user.getUserName(), user.getEmail(), user.getPhoneNumber(),
                user.getAddress(), user.getUserProfileId()) == 1;
    }
}
