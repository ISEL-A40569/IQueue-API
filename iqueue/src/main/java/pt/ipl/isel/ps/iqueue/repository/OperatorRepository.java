package pt.ipl.isel.ps.iqueue.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import pt.ipl.isel.ps.iqueue.model.Language;
import pt.ipl.isel.ps.iqueue.model.Operator;
import pt.ipl.isel.ps.iqueue.repository.rowmapper.OperatorRowMapper;

import java.util.List;

@Component
public class OperatorRepository {

    @Autowired
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    private final RowMapper<Operator> operatorRowMapper;

    public OperatorRepository(JdbcTemplate jdbcTemplate, OperatorRowMapper operatorRowMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.operatorRowMapper = operatorRowMapper;
    }

    private final String getQueryTemplate = "exec SelectOperator ?";

    public Operator getById(int operatorId) {
        return jdbcTemplate.queryForObject(getQueryTemplate, new Object[]{operatorId}, operatorRowMapper);
    }

    public List<Operator> getAll() {
        return jdbcTemplate.query(getQueryTemplate, new Object[]{null}, operatorRowMapper);
    }

    public boolean add(Operator operator) {
        String insertQueryTemplate = "exec Insert Operator ?, ?, ?, ?";

        return jdbcTemplate.update(insertQueryTemplate, operator.getOperatorDescription(),
                operator.getEmail(), operator.getPhoneNumber(), operator.getAddress()) == 1;
    }

    public boolean remove(int operatorId) {
        String removeQueryTemplate = "exec DeleteOperator ?";
        return jdbcTemplate.update(removeQueryTemplate, operatorId) == 1;
    }

    public boolean update(Operator operator) {
        String updateQueryTemplate = "exec UpdateOperator ?, ?, ?, ?, ?";
        return jdbcTemplate.update(updateQueryTemplate, operator.getOperatorId(), operator.getOperatorDescription(),
                operator.getEmail(), operator.getPhoneNumber(), operator.getAddress()) == 1;
    }
}
