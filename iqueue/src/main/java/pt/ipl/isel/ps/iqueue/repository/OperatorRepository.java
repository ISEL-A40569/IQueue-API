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
public class OperatorRepository extends Repository<Operator>{

    public OperatorRepository(JdbcTemplate jdbcTemplate, OperatorRowMapper operatorRowMapper) {
        super(jdbcTemplate, operatorRowMapper, "exec SelectOperator ?",
                "exec Insert Operator ?, ?, ?, ?",
                "exec DeleteOperator ?",
                "exec UpdateOperator ?, ?, ?, ?, ?");
    }

    public Operator getById(int operatorId) {
        return jdbcTemplate.queryForObject(getQueryTemplate, new Object[]{operatorId}, rowMapper);
    }

    public List<Operator> getAll() {
        return jdbcTemplate.query(getQueryTemplate, new Object[]{null}, rowMapper);
    }

    public boolean add(Operator operator) {

        return jdbcTemplate.update(insertQueryTemplate, operator.getOperatorDescription(),
                operator.getEmail(), operator.getPhoneNumber(), operator.getAddress()) == 1;
    }

    public boolean remove(int operatorId) {
        return jdbcTemplate.update(removeQueryTemplate, operatorId) == 1;
    }

    public boolean update(Operator operator) {
        return jdbcTemplate.update(updateQueryTemplate, operator.getOperatorId(), operator.getOperatorDescription(),
                operator.getEmail(), operator.getPhoneNumber(), operator.getAddress()) == 1;
    }
}
