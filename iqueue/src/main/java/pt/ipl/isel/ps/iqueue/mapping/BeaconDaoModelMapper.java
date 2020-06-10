package pt.ipl.isel.ps.iqueue.mapping;

import org.springframework.stereotype.Component;
import pt.ipl.isel.ps.iqueue.dao.BeaconDao;
import pt.ipl.isel.ps.iqueue.model.Beacon;

@Component
public class BeaconDaoModelMapper implements DaoModelMapper<BeaconDao, Beacon> {
    @Override
    public Beacon mapDaoToModel(BeaconDao dao) {
        return new Beacon(dao.getBeaconId(), dao.getBeaconMacAddress(),
                dao.getNamespaceId(), dao.getInstanceId(),
                dao.getManufacturer(), dao.getModel());
    }

    @Override
    public BeaconDao mapModelToDao(Beacon model) {
        return new BeaconDao(model.getBeaconId(), model.getBeaconMacAddress(),
                model.getNamespaceId(), model.getInstanceId(),
                model.getManufacturer(), model.getModel());
    }
}
