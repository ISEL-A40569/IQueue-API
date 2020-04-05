package pt.ipl.isel.ps.iqueue.repository.rowmapper;

import org.springframework.jdbc.core.RowMapper;
import pt.ipl.isel.ps.iqueue.model.OperatorUser;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OperatorUserRowMapper implements RowMapper<OperatorUser> {
    @Override
    public OperatorUser mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new OperatorUser(rs.getInt("operatorId"),
                rs.getInt("userId"));
    }
}
