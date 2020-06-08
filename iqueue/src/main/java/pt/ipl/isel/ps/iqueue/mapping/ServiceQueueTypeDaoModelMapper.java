package pt.ipl.isel.ps.iqueue.mapping;

import pt.ipl.isel.ps.iqueue.dao.ServiceQueueTypeDao;
import pt.ipl.isel.ps.iqueue.dao.embeddable.ServiceQueueTypeIds;
import pt.ipl.isel.ps.iqueue.model.ServiceQueueType;

public class ServiceQueueTypeDaoModelMapper implements DaoModelMapper<ServiceQueueTypeDao, ServiceQueueType> {
    @Override
    public ServiceQueueType mapDtoToModel(ServiceQueueTypeDao dao) {
        return new ServiceQueueType(dao.getServiceQueueTypeIds().getServiceQueueTypeId(),
                dao.getServiceQueueTypeIds().getLanguageId(),
                dao.getServiceQueueTypeDescription());
    }

    @Override
    public ServiceQueueTypeDao mapModelToDto(ServiceQueueType model) {
        return new ServiceQueueTypeDao(new ServiceQueueTypeIds(model.getServiceQueueTypeId(),
                model.getLanguageId()),
                model.getServiceQueueTypeDescription());
    }
}
