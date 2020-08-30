package pt.ipl.isel.ps.iqueue.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import pt.ipl.isel.ps.iqueue.dao.ServiceQueueDao;

import java.util.List;


@Component
public interface ServiceQueueRepository extends JpaRepository<ServiceQueueDao, Integer> {

    List<ServiceQueueDao> findByOperatorId(int operatorId);
}
