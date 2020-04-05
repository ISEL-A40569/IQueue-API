package pt.ipl.isel.ps.iqueue.repository.rowmapper;

import org.springframework.jdbc.core.RowMapper;
import pt.ipl.isel.ps.iqueue.model.ServiceQueueType;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ServiceQueueTypeRowMapper implements RowMapper<ServiceQueueType> {
    @Override
    public ServiceQueueType mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new ServiceQueueType(rs.getInt("serviceQueueTypeId"),
                rs.getInt("languageId"),
                rs.getString("serviceQueueTypeDescription"));
    }
}
