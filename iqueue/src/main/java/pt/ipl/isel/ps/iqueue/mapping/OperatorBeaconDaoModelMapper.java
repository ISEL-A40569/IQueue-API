package pt.ipl.isel.ps.iqueue.mapping;

import org.springframework.stereotype.Component;
import pt.ipl.isel.ps.iqueue.dao.OperatorBeaconDao;
import pt.ipl.isel.ps.iqueue.dao.embeddable.OperatorBeaconIds;
import pt.ipl.isel.ps.iqueue.model.OperatorBeacon;

@Component
public class OperatorBeaconDaoModelMapper implements DaoModelMapper<OperatorBeaconDao, OperatorBeacon> {
    @Override
    public OperatorBeacon mapDaoToModel(OperatorBeaconDao dao) {
        return new OperatorBeacon(dao.getOperatorBeaconIds().getOperatorId(),
                dao.getOperatorBeaconIds().getBeaconId());
    }

    @Override
    public OperatorBeaconDao mapModelToDao(OperatorBeacon model) {
        return new OperatorBeaconDao(new OperatorBeaconIds(model.getOperatorId(),
                model.getBeaconId()));
    }
}
