package pt.ipl.isel.ps.iqueue.mapping;

import pt.ipl.isel.ps.iqueue.dao.OperatorBeaconDao;
import pt.ipl.isel.ps.iqueue.dao.embeddable.OperatorBeaconIds;
import pt.ipl.isel.ps.iqueue.model.OperatorBeacon;

public class OperatorBeaconDaoModelMapper implements DaoModelMapper<OperatorBeaconDao, OperatorBeacon> {
    @Override
    public OperatorBeacon mapDtoToModel(OperatorBeaconDao dao) {
        return new OperatorBeacon(dao.getOperatorBeaconIds().getOperatorId(),
                dao.getOperatorBeaconIds().getBeaconId(),
                dao.getStartDate(), dao.getEndDate());
    }

    @Override
    public OperatorBeaconDao mapModelToDto(OperatorBeacon model) {
        return new OperatorBeaconDao(new OperatorBeaconIds(model.getOperatorId(),
                model.getBeaconId()), model.getStartDate(),
                model.getEndDate());
    }
}
