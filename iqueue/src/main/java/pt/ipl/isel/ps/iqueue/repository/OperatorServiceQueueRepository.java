package pt.ipl.isel.ps.iqueue.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import pt.ipl.isel.ps.iqueue.model.Language;
import pt.ipl.isel.ps.iqueue.model.OperatorServiceQueue;
import pt.ipl.isel.ps.iqueue.repository.rowmapper.LanguageRowMapper;
import pt.ipl.isel.ps.iqueue.repository.rowmapper.OperatorServiceQueueRowMapper;

import java.util.List;

@Component
public class OperatorServiceQueueRepository {

    @Autowired
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    private final RowMapper<OperatorServiceQueue> operatorServiceQueueRowMapper;

    private final String getQueryTemplate = "exec SelectOperatorServiceQueue ?, ?";

    public OperatorServiceQueueRepository(JdbcTemplate jdbcTemplate, OperatorServiceQueueRowMapper operatorServiceQueueRowMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.operatorServiceQueueRowMapper = operatorServiceQueueRowMapper;
    }

    public OperatorServiceQueue getByIds(int operatorId, int serviceQueueId) {
        return jdbcTemplate.queryForObject(getQueryTemplate, new Object[]{operatorId, serviceQueueId}, operatorServiceQueueRowMapper);
    }

    public List<OperatorServiceQueue> getAll() {
        return jdbcTemplate.query(getQueryTemplate, new Object[]{null, null}, operatorServiceQueueRowMapper);
    }

    public List<OperatorServiceQueue> getSome(int operatorId) {
        return jdbcTemplate.query(getQueryTemplate, new Object[]{operatorId, null}, operatorServiceQueueRowMapper);
    }

    public boolean add(OperatorServiceQueue operatorServiceQueue) {
        String insertQueryTemplate = "exec InsertOperatorServiceQueue ?, ?, ?, ?, ?";
        return jdbcTemplate.update(insertQueryTemplate, operatorServiceQueue.getOperatorId(),
                operatorServiceQueue.getServiceQueueId(), operatorServiceQueue.getServiceQueueDescription(),
                operatorServiceQueue.getServiceQueueTypeId(), operatorServiceQueue.getDailyLimit()) == 1;
    }

    public boolean remove(int languageId,  int serviceQueueId) {
        String deleteQueryTemplate = "exec DeleteOperatorServiceQueue ?, ?";
        return jdbcTemplate.update(deleteQueryTemplate, languageId, serviceQueueId) == 1;
    }

    public boolean update(OperatorServiceQueue operatorServiceQueue) {
        String updateQueryTemplate = "exec UpdateOperatorServiceQueue ?, ?, ?, ?, ?";
        return jdbcTemplate.update(updateQueryTemplate, operatorServiceQueue.getOperatorId(),
                operatorServiceQueue.getServiceQueueId(), operatorServiceQueue.getServiceQueueDescription(),
                operatorServiceQueue.getServiceQueueTypeId(), operatorServiceQueue.getDailyLimit()) == 1;    }
}
