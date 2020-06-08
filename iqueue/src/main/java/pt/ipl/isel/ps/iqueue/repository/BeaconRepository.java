package pt.ipl.isel.ps.iqueue.repository;



import org.springframework.data.repository.Repository;
import org.springframework.stereotype.Component;
import pt.ipl.isel.ps.iqueue.dao.BeaconDao;



@Component
public interface BeaconRepository extends Repository<BeaconDao, Integer> {

}
