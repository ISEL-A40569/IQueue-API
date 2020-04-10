package pt.ipl.isel.ps.iqueue.repository.rowmapper;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import pt.ipl.isel.ps.iqueue.model.ServiceQueueDesk;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class ServiceQueueDeskRowMapper implements RowMapper<ServiceQueueDesk> {
    @Override
    public ServiceQueueDesk mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new ServiceQueueDesk(rs.getInt("operatorId"),
                rs.getInt("serviceQueueId"),
                rs.getInt("deskId"));
    }
}
