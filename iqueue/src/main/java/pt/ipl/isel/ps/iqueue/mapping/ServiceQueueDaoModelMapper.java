package pt.ipl.isel.ps.iqueue.mapping;

import org.springframework.stereotype.Component;
import pt.ipl.isel.ps.iqueue.dao.ServiceQueueDao;
import pt.ipl.isel.ps.iqueue.model.ServiceQueue;

@Component
public class ServiceQueueDaoModelMapper implements DaoModelMapper<ServiceQueueDao, ServiceQueue> {
    @Override
    public ServiceQueue mapDaoToModel(ServiceQueueDao dao) {
        return new ServiceQueue(dao.getServiceQueueId(),
                dao.getOperatorId(),
                dao.getServiceQueueDescription(),
                dao.getServiceQueueTypeId(),
                dao.getDailyLimit());
    }

    @Override
    public ServiceQueueDao mapModelToDao(ServiceQueue model) {
        return new ServiceQueueDao(model.getServiceQueueId(),
                model.getOperatorId(),
                model.getServiceQueueDescription(),
                model.getServiceQueueTypeId(),
                model.getDailyLimit());
    }
}
