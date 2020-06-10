package pt.ipl.isel.ps.iqueue.mapping;

import org.springframework.stereotype.Component;
import pt.ipl.isel.ps.iqueue.dao.DeskDao;
import pt.ipl.isel.ps.iqueue.model.Desk;

@Component
public class DeskDaoModelMapper implements DaoModelMapper<DeskDao, Desk> {
    @Override
    public Desk mapDaoToModel(DeskDao dao) {
        return new Desk(dao.getDeskId(), dao.getServiceQueueId(),
                dao.getDeskDescription());
    }

    @Override
    public DeskDao mapModelToDao(Desk model) {
        return new DeskDao(model.getDeskId(), model.getServiceQueueId(),
                model.getDeskDescription());
    }
}
