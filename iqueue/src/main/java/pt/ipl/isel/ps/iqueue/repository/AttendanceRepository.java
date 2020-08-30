package pt.ipl.isel.ps.iqueue.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import pt.ipl.isel.ps.iqueue.dao.AttendanceDao;

import java.util.List;

@Component
public interface AttendanceRepository extends JpaRepository<AttendanceDao, Integer> {

    List<AttendanceDao> findByServiceQueueId (int serviceQueueId);

    List<AttendanceDao> findByClientId (int clientId);

    void deleteByServiceQueueId(int serviceQueueId);

    void deleteByClientId(int clientId);
}
