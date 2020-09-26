package pt.ipl.isel.ps.iqueue.mapping;

import org.springframework.stereotype.Component;
import pt.ipl.isel.ps.iqueue.dao.ServiceQueueTypeDao;
import pt.ipl.isel.ps.iqueue.dao.keys.ServiceQueueTypeIds;
import pt.ipl.isel.ps.iqueue.model.ServiceQueueType;

@Component
public class ServiceQueueTypeDaoModelMapper implements DaoModelMapper<ServiceQueueTypeDao, ServiceQueueType> {
    @Override
    public ServiceQueueType mapDaoToModel(ServiceQueueTypeDao dao) {
        return new ServiceQueueType(dao.getServiceQueueTypeIds().getServiceQueueTypeId(),
                dao.getServiceQueueTypeIds().getLanguageId(),
                dao.getServiceQueueTypeDescription());
    }

    @Override
    public ServiceQueueTypeDao mapModelToDao(ServiceQueueType model) {
        return new ServiceQueueTypeDao(new ServiceQueueTypeIds(model.getServiceQueueTypeId(),
                model.getLanguageId()),
                model.getServiceQueueTypeDescription());
    }
}
