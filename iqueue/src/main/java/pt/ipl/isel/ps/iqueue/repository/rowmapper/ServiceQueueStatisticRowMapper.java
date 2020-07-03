package pt.ipl.isel.ps.iqueue.repository.rowmapper;

import org.springframework.jdbc.core.RowMapper;
import pt.ipl.isel.ps.iqueue.model.ServiceQueueStatistic;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ServiceQueueStatisticRowMapper implements RowMapper<ServiceQueueStatistic> {

    @Override
    public ServiceQueueStatistic mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new ServiceQueueStatistic(rs.getInt("attendanceCount"),
                rs.getInt("averageWaitingSeconds"),
                rs.getInt("averageAttendanceSeconds"),
                rs.getFloat("averageRate"),
                rs.getInt("quitCount"));
    }
}
