package pt.ipl.isel.ps.iqueue.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import pt.ipl.isel.ps.iqueue.model.ServiceQueueType;
import pt.ipl.isel.ps.iqueue.repository.rowmapper.ServiceQueueTypeRowMapper;

import java.util.List;

@Component
public class ServiceQueueTypeRepository {

    @Autowired
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    private final RowMapper<ServiceQueueType> serviceQueueTypeRowMapper;

    private final String getQueryTemplate = "exec SelectServiceQueueType ?, ?";

    public ServiceQueueTypeRepository(JdbcTemplate jdbcTemplate, ServiceQueueTypeRowMapper serviceQueueTypeRowMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.serviceQueueTypeRowMapper = serviceQueueTypeRowMapper;
    }

    public ServiceQueueType getByIds(int serviceQueueTypeId, int languageId) {
        return jdbcTemplate.queryForObject(getQueryTemplate, new Object[]{serviceQueueTypeId, languageId}, serviceQueueTypeRowMapper);
    }

    public List<ServiceQueueType> getAll(int languageId) {
        return jdbcTemplate.query(getQueryTemplate, new Object[]{null, languageId}, serviceQueueTypeRowMapper);
    }

    public boolean add(ServiceQueueType serviceQueueType) {
        String insertQueryTemplate = "exec InsertServiceQueueType ?, ?, ?";

        return jdbcTemplate.update(insertQueryTemplate, serviceQueueType.getServiceQueueTypeId(),
                serviceQueueType.getLanguageId(), serviceQueueType.getServiceQueueTypeDescription()) == 1;
    }

    public boolean remove(int serviceQueueTypeId, int languageId) {
        String deleteQueryTemplate = "exec DeleteServiceQueueType ?, ?";

        return jdbcTemplate.update(deleteQueryTemplate, serviceQueueTypeId, languageId) > 0;
    }
    public boolean update(ServiceQueueType serviceQueueType) {
        String updateQueryTemplate = "exec UpdateServiceQueueType ?, ?, ?";

        return jdbcTemplate.update(updateQueryTemplate, serviceQueueType.getServiceQueueTypeId(),
                serviceQueueType.getLanguageId(), serviceQueueType.getServiceQueueTypeDescription()) == 1;
    }
}
