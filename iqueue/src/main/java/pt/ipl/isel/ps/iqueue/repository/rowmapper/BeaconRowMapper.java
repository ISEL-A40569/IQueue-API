package pt.ipl.isel.ps.iqueue.repository.rowmapper;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import pt.ipl.isel.ps.iqueue.model.Beacon;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class BeaconRowMapper implements RowMapper<Beacon> {
    @Override
    public Beacon mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Beacon(rs.findColumn("beaconId"),
                rs.getString("beaconMacAddress"),
                rs.getString("uidNamespaceId"),
                rs.getString("uidInstanceId"),
                rs.getString("iBeaconUuid"),
                rs.getString("iBeaconMajor"),
                rs.getString("iBeaconMinor"),
                rs.getString("manufacturer"),
                rs.getString("model"));
    }
}
