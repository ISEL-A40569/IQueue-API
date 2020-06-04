package pt.ipl.isel.ps.iqueue.repository.rowmapper;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import pt.ipl.isel.ps.iqueue.model.UserProfile;

import java.sql.ResultSet;
import java.sql.SQLException;

//@Component
//public class UserProfileRowMapper implements RowMapper<UserProfile> {
//    @Override
//    public UserProfile mapRow(ResultSet rs, int rowNum) throws SQLException {
//        return new UserProfile(rs.getInt("userProfileId"),
//                rs.getInt("languageId"),
//                rs.getString("userProfileDescription"));
//    }
//}
