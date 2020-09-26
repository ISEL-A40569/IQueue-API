package pt.ipl.isel.ps.iqueue.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import pt.ipl.isel.ps.iqueue.dao.OperatorBeaconDao;
import pt.ipl.isel.ps.iqueue.dao.keys.OperatorBeaconIds;

@Component
public interface OperatorBeaconRepository extends JpaRepository<OperatorBeaconDao, OperatorBeaconIds> {

    OperatorBeaconDao findByOperatorBeaconIdsBeaconId(int beaconId);

    void deleteByOperatorBeaconIdsBeaconId(int beaconId);

    void deleteByOperatorBeaconIdsOperatorId(int operatorId);
}
