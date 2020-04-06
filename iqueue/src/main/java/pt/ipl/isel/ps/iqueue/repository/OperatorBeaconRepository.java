package pt.ipl.isel.ps.iqueue.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import pt.ipl.isel.ps.iqueue.model.OperatorBeacon;
import pt.ipl.isel.ps.iqueue.model.OperatorServiceQueue;
import pt.ipl.isel.ps.iqueue.repository.rowmapper.OperatorBeaconRowMapper;

import java.util.List;

@Component
public class OperatorBeaconRepository {

    @Autowired
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    private final RowMapper<OperatorBeacon> operatorBeaconRowMapper;

    private final String getQueryTemplate = "exec SelectOperatorBeacon ?, ?";

    public OperatorBeaconRepository(JdbcTemplate jdbcTemplate, OperatorBeaconRowMapper operatorBeaconRowMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.operatorBeaconRowMapper = operatorBeaconRowMapper;
    }

    public List<OperatorBeacon> getOperatorBeacons(int operatorId) {
        return jdbcTemplate.query(getQueryTemplate, new Object[]{operatorId, null}, operatorBeaconRowMapper);
    }

    public List<OperatorBeacon> getBeaconOperator(int beaconId) {
        return jdbcTemplate.query(getQueryTemplate, new Object[]{null, beaconId}, operatorBeaconRowMapper);
    }

    public List<OperatorBeacon> getAll() {
        return jdbcTemplate.query(getQueryTemplate, new Object[]{null, null}, operatorBeaconRowMapper);
    }

    public boolean add(OperatorBeacon operatorBeacon) {
        String insertQueryTemplate = "exec InsertOperatorBeacon ?, ?";
        return jdbcTemplate.update(insertQueryTemplate, operatorBeacon.getOperatorId(),
                operatorBeacon.getBeaconId()) == 1;
    }

    public boolean remove(int operatorId, int beaconId) {
        String deleteQueryTemplate = "exec DeleteOperatorBeacon ?, ?";
        return jdbcTemplate.update(deleteQueryTemplate, operatorId,
                beaconId) == 1;
    }
}
