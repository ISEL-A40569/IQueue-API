package pt.ipl.isel.ps.iqueue.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import pt.ipl.isel.ps.iqueue.model.ServiceQueueType;
import pt.ipl.isel.ps.iqueue.repository.rowmapper.ServiceQueueTypeRowMapper;

import java.util.List;

@Component
public class ServiceQueueTypeRepository extends Repository<ServiceQueueType>{

    public ServiceQueueTypeRepository(JdbcTemplate jdbcTemplate, ServiceQueueTypeRowMapper serviceQueueTypeRowMapper) {
        super(jdbcTemplate, serviceQueueTypeRowMapper, "exec SelectServiceQueueType ?, ?",
                "exec InsertServiceQueueType ?, ?, ?",
                "exec DeleteServiceQueueType ?, ?",
                "exec UpdateServiceQueueType ?, ?, ?");
    }

    public ServiceQueueType getByIds(int serviceQueueTypeId, int languageId) {
        return jdbcTemplate.queryForObject(getQueryTemplate, new Object[]{serviceQueueTypeId, languageId}, rowMapper);
    }

    public List<ServiceQueueType> getAll(int languageId) {
        return jdbcTemplate.query(getQueryTemplate, new Object[]{null, languageId}, rowMapper);
    }

    @Override
    public ServiceQueueType getById(int id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<ServiceQueueType> getAll() {
        throw new UnsupportedOperationException();
    }

    public int add(ServiceQueueType serviceQueueType) {
        return jdbcTemplate.update(insertQueryTemplate, serviceQueueType.getServiceQueueTypeId(),
                serviceQueueType.getLanguageId(), serviceQueueType.getServiceQueueTypeDescription()) == 1 ?
                serviceQueueType.getServiceQueueTypeId() : 0;
    }

    @Override
    public boolean remove(int id) {
        throw new UnsupportedOperationException();
    }

    public boolean remove(int serviceQueueTypeId, int languageId) {
        return jdbcTemplate.update(removeQueryTemplate, serviceQueueTypeId, languageId) > 0;
    }
    public boolean update(ServiceQueueType serviceQueueType) {
        return jdbcTemplate.update(updateQueryTemplate, serviceQueueType.getServiceQueueTypeId(),
                serviceQueueType.getLanguageId(), serviceQueueType.getServiceQueueTypeDescription()) == 1;
    }
}
