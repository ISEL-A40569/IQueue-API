package pt.ipl.isel.ps.iqueue.repository.rowmapper;

import org.springframework.jdbc.core.RowMapper;
import pt.ipl.isel.ps.iqueue.model.OperatorBeacon;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OperatorBeaconRowMapper implements RowMapper<OperatorBeacon> {
    @Override
    public OperatorBeacon mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new OperatorBeacon(rs.getInt("operatorId"),
                rs.getInt("beaconId"));
    }
}
