package pt.ipl.isel.ps.iqueue.mapping;

import pt.ipl.isel.ps.iqueue.dao.OperatorUserDao;
import pt.ipl.isel.ps.iqueue.dao.embeddable.OperatorUserIds;
import pt.ipl.isel.ps.iqueue.model.OperatorUser;

public class OperatorUserDaoModelMapper implements DaoModelMapper<OperatorUserDao, OperatorUser> {
    @Override
    public OperatorUser mapDtoToModel(OperatorUserDao dao) {
        return new OperatorUser(dao.getOperatorUserIds().getOperatorId(),
                dao.getOperatorUserIds().getUserId());
    }

    @Override
    public OperatorUserDao mapModelToDto(OperatorUser model) {
        return new OperatorUserDao(new OperatorUserIds(model.getOperatorId(),
                model.getUserId()));
    }
}
