package pt.ipl.isel.ps.iqueue.repository.rowmapper;

import org.springframework.jdbc.core.RowMapper;
import pt.ipl.isel.ps.iqueue.model.Attendance;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class AttendanceRowMapper implements RowMapper<Attendance> {
    @Override
    public Attendance mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Attendance(rs.getInt("attendanceId"),
                rs.getInt("operatorId"),
                rs.getInt("serviceQueueId"),
                rs.getInt("deskId"),
                rs.getInt("clientId"),
                LocalDateTime.parse(rs.getDate("startWaitingTime").toString()),
                LocalDateTime.parse(rs.getDate("endWaitingTime").toString()),
                LocalDateTime.parse(rs.getDate("startAttendanceTime").toString()),
                LocalDateTime.parse(rs.getDate("endAttendanceTime").toString()),
                rs.getInt("attendanceStatusId"),
                rs.getInt("attendanceUserId"));
    }
}
