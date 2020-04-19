package pt.ipl.isel.ps.iqueue.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import pt.ipl.isel.ps.iqueue.model.ServiceQueueDesk;
import pt.ipl.isel.ps.iqueue.repository.rowmapper.ServiceQueueDeskRowMapper;

import java.util.List;

@Component
public class ServiceQueueDeskRepository {
    @Autowired
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    private final RowMapper<ServiceQueueDesk> serviceQueueDeskRowMapper;

    private final String getQueryTemplate = "exec SelectServiceQueueDesk ?, ?";

    public ServiceQueueDeskRepository(JdbcTemplate jdbcTemplate, ServiceQueueDeskRowMapper serviceQueueDeskRowMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.serviceQueueDeskRowMapper = serviceQueueDeskRowMapper;
    }

    public List<ServiceQueueDesk> getServiceQueueDesks(int operatorId, int serviceQueueId) {
        return jdbcTemplate.query(getQueryTemplate, new Object[]{operatorId, serviceQueueId}, serviceQueueDeskRowMapper);
    }

    public List<ServiceQueueDesk> getAll() {
        return jdbcTemplate.query(getQueryTemplate, new Object[]{null, null}, serviceQueueDeskRowMapper);
    }

    public int add(ServiceQueueDesk serviceQueueDesk) {
        String insertQueryTemplate = "exec InsertServiceQueueDesk ?, ?, ?";
        return jdbcTemplate.queryForObject(insertQueryTemplate, new Object[]{serviceQueueDesk.getOperatorId(),
                serviceQueueDesk.getServiceQueueId(), serviceQueueDesk.getDeskDescription()}, Integer.class);
    }

    public boolean remove(int operatorId, int serviceQueueId, int deskId) {
        String removeQueryTemplate = "exec DeleteServiceQueueDesk ?, ?, ?";
        return jdbcTemplate.update(removeQueryTemplate, operatorId, serviceQueueId, deskId) == 1;
    }

    public boolean update(ServiceQueueDesk serviceQueueDesk) {
        String updateQueryTemplate = "exec UpdateServiceQueueDesk ?, ?";
        return jdbcTemplate.update(updateQueryTemplate, serviceQueueDesk.getDeskId(),
                serviceQueueDesk.getDeskDescription()) == 1;
    }}
