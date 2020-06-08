package pt.ipl.isel.ps.iqueue.mapping;

import pt.ipl.isel.ps.iqueue.dao.DeskUserDao;
import pt.ipl.isel.ps.iqueue.dao.embeddable.DeskUserIds;
import pt.ipl.isel.ps.iqueue.model.DeskUser;

public class DeskUserDaoModelMapper implements DaoModelMapper<DeskUserDao, DeskUser> {
    @Override
    public DeskUser mapDtoToModel(DeskUserDao dao) {
        return new DeskUser(dao.getDeskUserIds().getDeskId(),
                dao.getDeskUserIds().getUserId(),
                dao.getStartDate(), dao.getEndDate());
    }

    @Override
    public DeskUserDao mapModelToDto(DeskUser model) {
        return new DeskUserDao(new DeskUserIds(model.getDeskId(),
                model.getUserId()), model.getStartDate(),
                model.getEndDate());
    }
}
