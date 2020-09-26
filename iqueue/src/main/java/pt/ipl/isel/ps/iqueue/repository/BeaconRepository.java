package pt.ipl.isel.ps.iqueue.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import pt.ipl.isel.ps.iqueue.dao.BeaconDao;


@Component
public interface BeaconRepository extends JpaRepository<BeaconDao, Integer> {

    BeaconDao findByNamespaceIdAndInstanceId(String namespaceId, String instanceId);

}
