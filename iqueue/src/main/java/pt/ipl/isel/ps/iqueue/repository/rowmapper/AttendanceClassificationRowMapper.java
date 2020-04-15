package pt.ipl.isel.ps.iqueue.repository.rowmapper;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import pt.ipl.isel.ps.iqueue.model.AttendanceClassification;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

import static pt.ipl.isel.ps.iqueue.utils.SQLTimestampToLocalDateTimeConverter.convertSQLTimestampToLocalDateTime;

@Component
public class AttendanceClassificationRowMapper implements RowMapper<AttendanceClassification> {

    @Override
    public AttendanceClassification mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new AttendanceClassification(rs.getInt("attendanceId"),
                convertSQLTimestampToLocalDateTime(rs.getTimestamp("classificationCreationTime")),
                rs.getInt("rate"),
                rs.getString("observations"));
    }
}
