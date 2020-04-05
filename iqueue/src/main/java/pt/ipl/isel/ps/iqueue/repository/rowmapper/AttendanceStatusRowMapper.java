package pt.ipl.isel.ps.iqueue.repository.rowmapper;

import org.springframework.jdbc.core.RowMapper;
import pt.ipl.isel.ps.iqueue.model.AttendanceStatus;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AttendanceStatusRowMapper implements RowMapper<AttendanceStatus> {
    @Override
    public AttendanceStatus mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new AttendanceStatus(rs.getInt("attendanceStatusId"),
                rs.getInt("languageId"),
                rs.getString("attendanceStatusDescription"));
    }
}
