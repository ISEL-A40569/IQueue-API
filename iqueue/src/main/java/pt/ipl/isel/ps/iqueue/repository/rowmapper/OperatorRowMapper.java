package pt.ipl.isel.ps.iqueue.repository.rowmapper;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import pt.ipl.isel.ps.iqueue.model.Operator;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class OperatorRowMapper implements RowMapper<Operator> {
    @Override
    public Operator mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Operator(rs.getInt("operatorId"),
                rs.getString("operatorDescription"),
                rs.getString("email"),
                rs.getInt("phoneNumber"),
                rs.getString("address"));
    }
}
