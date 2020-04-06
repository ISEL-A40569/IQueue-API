package pt.ipl.isel.ps.iqueue.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import pt.ipl.isel.ps.iqueue.model.OperatorUser;
import pt.ipl.isel.ps.iqueue.repository.rowmapper.OperatorUserRowMapper;

import java.util.List;

@Component
public class OperatorUserRepository {

    @Autowired
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    private final RowMapper<OperatorUser> operatorUserRowMapper;

    private final String getQueryTemplate = "exec SelectOperatorUser ?";

    public OperatorUserRepository(JdbcTemplate jdbcTemplate, OperatorUserRowMapper operatorUserRowMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.operatorUserRowMapper = operatorUserRowMapper;
    }

    public List<OperatorUser> getSome(int operatorId) {
        return jdbcTemplate.query(getQueryTemplate, new Object[]{operatorId}, operatorUserRowMapper);
    }

    public List<OperatorUser> getAll() {
        return jdbcTemplate.query(getQueryTemplate, new Object[]{null}, operatorUserRowMapper);
    }

    public boolean add(OperatorUser operatorUser) {
        String insertQueryTemplate = "exec InsertOperatorUser ?, ?";
        return jdbcTemplate.update(insertQueryTemplate, operatorUser.getOperatorId(), operatorUser.getUserId()) == 1;
    }

    public boolean remove(int operatorId, int userId) {
        String removeQueryTemplate = "exec DeleteOperatorUser ?, ?";
        return jdbcTemplate.update(removeQueryTemplate, operatorId, userId) == 1;
    }
}
