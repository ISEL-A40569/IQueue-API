package pt.ipl.isel.ps.iqueue.repository.rowmapper;

import org.springframework.jdbc.core.RowMapper;
import pt.ipl.isel.ps.iqueue.model.ServiceQueueDeskUser;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class ServiceQueueDeskUserRowMapper implements RowMapper<ServiceQueueDeskUser> {
    @Override
    public ServiceQueueDeskUser mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new ServiceQueueDeskUser(rs.getInt("operatorId"),
                rs.getInt("serviceQueueId"),
                rs.getInt("deskId"),
                rs.getInt("userId"),
                LocalDateTime.parse(rs.getDate("date").toString()));
    }
}
