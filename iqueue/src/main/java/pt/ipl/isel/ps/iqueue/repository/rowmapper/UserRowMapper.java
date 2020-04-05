package pt.ipl.isel.ps.iqueue.repository.rowmapper;

import org.springframework.jdbc.core.RowMapper;
import pt.ipl.isel.ps.iqueue.model.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new User(rs.getInt("userID"),
                rs.getString("userName"),
                rs.getString("email"),
                rs.getInt("phoneNumber"),
                rs.getString("address"),
                rs.getInt("userProfileId"));
    }
}
