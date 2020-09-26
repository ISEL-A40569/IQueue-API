package pt.ipl.isel.ps.iqueue.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import pt.ipl.isel.ps.iqueue.model.NextAttendance;
import pt.ipl.isel.ps.iqueue.repository.rowmapper.NextAttendanceRowMapper;

import java.util.Optional;

@Component
public class NextAttendanceRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public Optional<NextAttendance> get(int deskId) {
        String query = "exec GetNextAttendance ?";

        return Optional.of(jdbcTemplate.queryForObject(query, new Object[]{deskId}, new NextAttendanceRowMapper()));
    }
}
