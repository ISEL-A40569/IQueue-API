package pt.ipl.isel.ps.iqueue.repository.rowmapper;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import pt.ipl.isel.ps.iqueue.model.Attendance;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import static pt.ipl.isel.ps.iqueue.utils.SQLTimestampToLocalDateTimeConverter.convertSQLTimestampToLocalDateTime;

@Component
public class AttendanceRowMapper implements RowMapper<Attendance> {
    @Override
    public Attendance mapRow(ResultSet rs, int rowNum) throws SQLException {
        LocalDateTime startWaitingTime = rs.getTimestamp("startWaitingTime").toLocalDateTime();
        return new Attendance(rs.getInt("attendanceId"),
                rs.getInt("operatorId"),
                rs.getInt("serviceQueueId"),
                rs.getInt("deskId"),
                rs.getInt("clientId"),
                convertSQLTimestampToLocalDateTime(rs.getTimestamp("startWaitingTime")),
                convertSQLTimestampToLocalDateTime(rs.getTimestamp("endWaitingTime")),
                convertSQLTimestampToLocalDateTime(rs.getTimestamp("startAttendanceTime")),
                convertSQLTimestampToLocalDateTime(rs.getTimestamp("endAttendanceTime")),
                rs.getInt("attendanceStatusId"),
                rs.getInt("attendanceUserId"));
    }
}
