package pt.ipl.isel.ps.iqueue.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import pt.ipl.isel.ps.iqueue.model.ServiceQueueStatistic;

import java.util.Optional;

@Component
public class ServiceQueueStatisticRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public Optional<ServiceQueueStatistic> get(int serviceQueueId) {
        String query = "exec GetServiceQueueStatistics ?";

        return Optional.of(jdbcTemplate.queryForObject(query, new Object[] { serviceQueueId }, new ServiceQueueStatisticRowMapper()));
    }
}
