package pt.ipl.isel.ps.iqueue.mapping;

import pt.ipl.isel.ps.iqueue.dao.DeskDao;
import pt.ipl.isel.ps.iqueue.model.Desk;

public class DeskDaoModelMapper implements DaoModelMapper<DeskDao, Desk> {
    @Override
    public Desk mapDtoToModel(DeskDao dao) {
        return new Desk(dao.getDeskId(), dao.getServiceQueueId(),
                dao.getDeskDescription());
    }

    @Override
    public DeskDao mapModelToDto(Desk model) {
        return new DeskDao(model.getDeskId(), model.getServiceQueueId(),
                model.getDeskDescription());
    }
}
