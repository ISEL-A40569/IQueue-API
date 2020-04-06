package pt.ipl.isel.ps.iqueue.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import pt.ipl.isel.ps.iqueue.model.ServiceQueueDeskUser;
import pt.ipl.isel.ps.iqueue.repository.rowmapper.ServiceQueueDeskUserRowMapper;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class ServiceQueueDeskUserRepository  {

    @Autowired
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    private final RowMapper<ServiceQueueDeskUser> serviceQueueDeskUserRowMapper;

    public ServiceQueueDeskUserRepository(JdbcTemplate jdbcTemplate, ServiceQueueDeskUserRowMapper serviceQueueDeskUserRowMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.serviceQueueDeskUserRowMapper = serviceQueueDeskUserRowMapper;
    }

    public List<ServiceQueueDeskUser> getSome(int operatorId, int serviceQueueId, int deskId, int userId, LocalDateTime date) {
        String getQueryTemplate = "exec SelectServiceQueueDeskUser ?, ?, ?, ?, ?";
        return jdbcTemplate.query(getQueryTemplate, new Object[]{null}, serviceQueueDeskUserRowMapper);
    }

    public boolean add(ServiceQueueDeskUser serviceQueueDeskUser) {
        String insertQueryTemplate = "exec InsertServiceQueueDeskUser ?, ?, ?, ?, ?";
        return jdbcTemplate.update(insertQueryTemplate, serviceQueueDeskUser.getOperatorId(),
                serviceQueueDeskUser.getServiceQueueId(),
                serviceQueueDeskUser.getDeskId(),
                serviceQueueDeskUser.getUserId(),
                LocalDateTime.now()) == 1;
    }

    public boolean remove(ServiceQueueDeskUser serviceQueueDeskUser) {  // TODO: review this SP query
        String removeQueryTemplate = "exec DeleteServiceQueueDeskUser ?, ?, ?, ?, ?";
        return jdbcTemplate.update(removeQueryTemplate, serviceQueueDeskUser.getOperatorId(),
                serviceQueueDeskUser.getServiceQueueId(),
                serviceQueueDeskUser.getDeskId(),
                serviceQueueDeskUser.getUserId(),
                LocalDateTime.now()) == 1;
    }
}
