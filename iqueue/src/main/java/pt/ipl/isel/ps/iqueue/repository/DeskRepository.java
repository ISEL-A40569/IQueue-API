package pt.ipl.isel.ps.iqueue.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import pt.ipl.isel.ps.iqueue.dao.DeskDao;

import java.util.List;

@Component
public interface DeskRepository extends JpaRepository<DeskDao, Integer> {
    List<DeskDao> findByServiceQueueId(int serviceQueueId);

    void deleteByServiceQueueId(int serviceQueueId);
}
