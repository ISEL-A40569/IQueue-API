package pt.ipl.isel.ps.iqueue.repository.rowmapper;

import org.springframework.jdbc.core.RowMapper;
import pt.ipl.isel.ps.iqueue.model.ServiceQueueWaitingCount;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ServiceQueueWaitingCountRowMapper implements RowMapper<ServiceQueueWaitingCount> {


    @Override
    public ServiceQueueWaitingCount mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new ServiceQueueWaitingCount(rs.getInt("waitingCount"));
    }
}
