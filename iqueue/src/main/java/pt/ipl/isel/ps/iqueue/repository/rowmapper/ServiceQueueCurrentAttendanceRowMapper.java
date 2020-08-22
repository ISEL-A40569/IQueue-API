package pt.ipl.isel.ps.iqueue.repository.rowmapper;

import org.springframework.jdbc.core.RowMapper;
import pt.ipl.isel.ps.iqueue.model.ServiceQueueCurrentAttendance;

import java.sql.ResultSet;
import java.sql.SQLException;


public class ServiceQueueCurrentAttendanceRowMapper implements RowMapper<ServiceQueueCurrentAttendance> {

    @Override
    public ServiceQueueCurrentAttendance mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new ServiceQueueCurrentAttendance(rs.getInt("ticketNumber"));
    }
}
