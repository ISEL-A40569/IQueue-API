package pt.ipl.isel.ps.iqueue.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import pt.ipl.isel.ps.iqueue.model.ServiceQueueWaitingCount;
import pt.ipl.isel.ps.iqueue.repository.rowmapper.ServiceQueueWaitingCountRowMapper;

import java.util.Optional;

@Component
public class ServiceQueueWaitingCountRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public Optional<ServiceQueueWaitingCount> getServiceQueueWaitingCountFromDesk(int deskId) {
        String query = "exec GetServiceQueueWaitingCountFromDesk ?";
        return getWaitingCount(query, deskId);
    }

    public Optional<ServiceQueueWaitingCount> getServiceQueueWaitingCount(int serviceQueueId) {
        String query = "exec GetServiceQueueWaitingCount ?";
        return getWaitingCount(query, serviceQueueId);
    }

    private Optional<ServiceQueueWaitingCount> getWaitingCount(String query, int id) {
        return Optional.ofNullable(jdbcTemplate.queryForObject(query, new Object[]{id}, new ServiceQueueWaitingCountRowMapper()));
    }
}
