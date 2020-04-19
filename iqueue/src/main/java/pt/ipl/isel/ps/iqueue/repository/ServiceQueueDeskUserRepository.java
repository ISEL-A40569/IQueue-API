package pt.ipl.isel.ps.iqueue.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import pt.ipl.isel.ps.iqueue.model.ServiceQueueDeskUser;
import pt.ipl.isel.ps.iqueue.repository.rowmapper.ServiceQueueDeskUserRowMapper;

import java.time.LocalDate;
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

    public List<ServiceQueueDeskUser> getDeskUsers(int operatorId, int serviceQueueId, int deskId) {
        String getQueryTemplate = "exec SelectServiceQueueDeskUser ?, ?, ?, ?, ?";
        return jdbcTemplate.query(getQueryTemplate, new Object[]{operatorId, serviceQueueId, deskId,
        null, null}, serviceQueueDeskUserRowMapper);
    }

    public List<ServiceQueueDeskUser> getDeskUsersByDate(int operatorId, int serviceQueueId, int deskId, String date) {
        String getQueryTemplate = "exec SelectServiceQueueDeskUser ?, ?, ?, ?, ?";
        return jdbcTemplate.query(getQueryTemplate, new Object[]{operatorId, serviceQueueId, deskId,
                null, date}, serviceQueueDeskUserRowMapper);
    }

    public List<ServiceQueueDeskUser> getDeskUserDates(int operatorId, int serviceQueueId, int deskId, int userId) {
        String getQueryTemplate = "exec SelectServiceQueueDeskUser ?, ?, ?, ?, ?";
        return jdbcTemplate.query(getQueryTemplate, new Object[]{operatorId, serviceQueueId, deskId,
                userId, null}, serviceQueueDeskUserRowMapper);
    }

    public List<ServiceQueueDeskUser> getUserDesks(int userId) {
        String getQueryTemplate = "exec SelectServiceQueueDeskUser ?, ?, ?, ?, ?";
        return jdbcTemplate.query(getQueryTemplate, new Object[]{null, null, null,
                userId, null}, serviceQueueDeskUserRowMapper);
    }

    public List<ServiceQueueDeskUser> getUserDesksByDate(int userId, String date) {
        String getQueryTemplate = "exec SelectServiceQueueDeskUser ?, ?, ?, ?, ?";
        return jdbcTemplate.query(getQueryTemplate, new Object[]{null, null, null,
                userId, date}, serviceQueueDeskUserRowMapper);
    }

    public boolean add(ServiceQueueDeskUser serviceQueueDeskUser) {
        String insertQueryTemplate = "exec InsertServiceQueueDeskUser ?, ?, ?, ?, ?";
        return jdbcTemplate.update(insertQueryTemplate, serviceQueueDeskUser.getOperatorId(),
                    serviceQueueDeskUser.getServiceQueueId(),
                    serviceQueueDeskUser.getDeskId(),
                    serviceQueueDeskUser.getUserId(),
                    serviceQueueDeskUser.getDate()) == 1;
    }

    public boolean remove(int operadorId, int serviceQueueId, int deskId, int userId, String date) {
        String removeQueryTemplate = "exec DeleteServiceQueueDeskUser ?, ?, ?, ?, ?";
        return jdbcTemplate.update(removeQueryTemplate, operadorId, serviceQueueId, deskId, userId, date) == 1;
    }
}
