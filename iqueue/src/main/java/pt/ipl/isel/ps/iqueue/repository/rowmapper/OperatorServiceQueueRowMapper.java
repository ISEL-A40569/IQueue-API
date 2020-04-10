package pt.ipl.isel.ps.iqueue.repository.rowmapper;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import pt.ipl.isel.ps.iqueue.model.OperatorServiceQueue;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class OperatorServiceQueueRowMapper implements RowMapper<OperatorServiceQueue> {
    @Override
    public OperatorServiceQueue mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new OperatorServiceQueue(rs.getInt("operatorId"),
                rs.getInt("serviceQueueId"),
                rs.getString("serviceQueueDescription"),
                rs.getInt("serviceQueueTypeId"),
                rs.getInt("dailyLimit"));
    }
}
