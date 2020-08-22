package pt.ipl.isel.ps.iqueue.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import pt.ipl.isel.ps.iqueue.model.ServiceQueueCurrentAttendance;
import pt.ipl.isel.ps.iqueue.model.ServiceQueueWaitingCount;
import pt.ipl.isel.ps.iqueue.repository.rowmapper.ServiceQueueCurrentAttendanceRowMapper;
import pt.ipl.isel.ps.iqueue.repository.rowmapper.ServiceQueueWaitingCountRowMapper;

import java.util.Optional;

@Component
public class ServiceQueueCurrentAttendanceRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public Optional<ServiceQueueCurrentAttendance> get(int serviceQueueId) {
        String query = "exec GetCurrentAttendance ?";

        return Optional.of(jdbcTemplate.queryForObject(query, new Object[] { serviceQueueId }, new ServiceQueueCurrentAttendanceRowMapper()));
    }
}
