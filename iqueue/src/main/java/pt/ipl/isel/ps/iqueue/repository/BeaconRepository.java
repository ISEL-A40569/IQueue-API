package pt.ipl.isel.ps.iqueue.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import pt.ipl.isel.ps.iqueue.model.Beacon;
import pt.ipl.isel.ps.iqueue.repository.rowmapper.BeaconRowMapper;

import java.util.List;

@Component
public class BeaconRepository extends Repository<Beacon> {

    public BeaconRepository(JdbcTemplate jdbcTemplate, BeaconRowMapper beaconRowMapper) {
        super(jdbcTemplate, beaconRowMapper, "exec SelectBeacon ?",
                "exec InsertBeacon ?, ?, ?, ?, ?, ?, ?, ?",
                "exec DeleteBeacon ?",
                "exec UpdateBeacon ?, ?, ?, ?, ?, ?, ?, ?, ?");
    }

    @Override
    public Beacon getById(int beaconId) {
        return jdbcTemplate.queryForObject(getQueryTemplate, new Object[]{beaconId}, rowMapper);
    }

    @Override
    public List<Beacon> getAll() {
        return jdbcTemplate.query(getQueryTemplate, new Object[]{null}, rowMapper);
    }

    @Override
    public int add(Beacon beacon) {
        return jdbcTemplate.update(insertQueryTemplate, beacon.getBeaconMacAddress(),
                beacon.getUidNamespaceId(), beacon.getUidInstanceId(),
                beacon.getiBeaconUuid(), beacon.getiBeaconMajor(),
                beacon.getiBeaconMinor(), beacon.getManufacturer(),
                beacon.getModel());
    }

    @Override
    public boolean remove(int beaconId) {
        return jdbcTemplate.update(removeQueryTemplate, beaconId) == 1;
    }

    @Override
    public boolean update(Beacon beacon) {
        return jdbcTemplate.update(insertQueryTemplate, beacon.getBeaconId(),
                beacon.getBeaconMacAddress(), beacon.getUidNamespaceId(),
                beacon.getUidInstanceId(), beacon.getiBeaconUuid(),
                beacon.getiBeaconMajor(), beacon.getiBeaconMinor(),
                beacon.getManufacturer(), beacon.getModel()) == 1;
    }
}
