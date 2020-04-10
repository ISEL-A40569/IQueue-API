package pt.ipl.isel.ps.iqueue.repository.rowmapper;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import pt.ipl.isel.ps.iqueue.model.AttendanceClassification;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

@Component
public class AttendanceClassificationRowMapper implements RowMapper<AttendanceClassification> {

    @Override
    public AttendanceClassification mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new AttendanceClassification(rs.getInt("attendanceId"),
                LocalDateTime.parse(rs.getDate("classificationCreationTime").toString()),
                rs.getInt("rate"),
                rs.getString("observations"));
    }
}
