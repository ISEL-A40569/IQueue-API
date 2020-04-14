package pt.ipl.isel.ps.iqueue.repository.rowmapper;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import pt.ipl.isel.ps.iqueue.model.ServiceQueueDeskUser;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Component
public class ServiceQueueDeskUserRowMapper implements RowMapper<ServiceQueueDeskUser> {
    @Override
    public ServiceQueueDeskUser mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new ServiceQueueDeskUser(rs.getInt("operatorId"),
                rs.getInt("serviceQueueId"),
                rs.getInt("deskId"),
                rs.getInt("userId"),
                LocalDate.parse(rs.getDate("date").toString()));
    }
}
