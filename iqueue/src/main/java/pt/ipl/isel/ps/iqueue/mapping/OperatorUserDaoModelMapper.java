package pt.ipl.isel.ps.iqueue.mapping;

import org.springframework.stereotype.Component;
import pt.ipl.isel.ps.iqueue.dao.OperatorUserDao;
import pt.ipl.isel.ps.iqueue.dao.keys.OperatorUserIds;
import pt.ipl.isel.ps.iqueue.model.OperatorUser;

@Component
public class OperatorUserDaoModelMapper implements DaoModelMapper<OperatorUserDao, OperatorUser> {
    @Override
    public OperatorUser mapDaoToModel(OperatorUserDao dao) {
        return new OperatorUser(dao.getOperatorUserIds().getOperatorId(),
                dao.getOperatorUserIds().getUserId());
    }

    @Override
    public OperatorUserDao mapModelToDao(OperatorUser model) {
        return new OperatorUserDao(new OperatorUserIds(model.getOperatorId(),
                model.getUserId()));
    }
}
