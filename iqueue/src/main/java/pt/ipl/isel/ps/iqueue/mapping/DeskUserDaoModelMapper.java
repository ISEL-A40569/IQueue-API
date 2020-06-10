package pt.ipl.isel.ps.iqueue.mapping;

import org.springframework.stereotype.Component;
import pt.ipl.isel.ps.iqueue.dao.DeskUserDao;
import pt.ipl.isel.ps.iqueue.dao.embeddable.DeskUserIds;
import pt.ipl.isel.ps.iqueue.model.DeskUser;

@Component
public class DeskUserDaoModelMapper implements DaoModelMapper<DeskUserDao, DeskUser> {
    @Override
    public DeskUser mapDaoToModel(DeskUserDao dao) {
        return new DeskUser(dao.getDeskUserIds().getDeskId(),
                dao.getDeskUserIds().getUserId());
    }

    @Override
    public DeskUserDao mapModelToDao(DeskUser model) {
        return new DeskUserDao(new DeskUserIds(model.getDeskId(),
                model.getUserId()));
    }
}
