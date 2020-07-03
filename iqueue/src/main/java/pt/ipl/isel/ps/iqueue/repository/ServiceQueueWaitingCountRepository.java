package pt.ipl.isel.ps.iqueue.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import pt.ipl.isel.ps.iqueue.model.ServiceQueueWaitingCount;
import pt.ipl.isel.ps.iqueue.repository.rowmapper.ServiceQueueWaitingCountRowMapper;

import java.util.Optional;

public class ServiceQueueWaitingCountRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public Optional<ServiceQueueWaitingCount> get(int deskId) {
        String query = "exec GetServiceQueueWaitingCount ?";

        return Optional.of(jdbcTemplate.queryForObject(query, new Object[] { deskId }, new ServiceQueueWaitingCountRowMapper()));
    }
}
