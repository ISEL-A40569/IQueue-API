package pt.ipl.isel.ps.iqueue.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import pt.ipl.isel.ps.iqueue.dao.ServiceQueueTypeDao;
import pt.ipl.isel.ps.iqueue.dao.keys.ServiceQueueTypeIds;

@Component
public interface ServiceQueueTypeRepository extends JpaRepository<ServiceQueueTypeDao, ServiceQueueTypeIds> {

}
