package pt.ipl.isel.ps.iqueue.repository.rowmapper;

import org.springframework.jdbc.core.RowMapper;
import pt.ipl.isel.ps.iqueue.model.NextAttendance;
import pt.ipl.isel.ps.iqueue.model.ServiceQueueWaitingCount;

import java.sql.ResultSet;
import java.sql.SQLException;

public class NextAttendanceRowMapper implements RowMapper<NextAttendance> {
    @Override
    public NextAttendance mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new NextAttendance(rs.getInt("nextAttendance"));
    }
}
