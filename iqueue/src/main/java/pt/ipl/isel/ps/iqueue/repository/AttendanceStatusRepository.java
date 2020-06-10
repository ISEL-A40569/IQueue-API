package pt.ipl.isel.ps.iqueue.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import pt.ipl.isel.ps.iqueue.dao.AttendanceStatusDao;
import pt.ipl.isel.ps.iqueue.dao.embeddable.AttendanceStatusIds;


@Component
public interface AttendanceStatusRepository extends JpaRepository<AttendanceStatusDao, AttendanceStatusIds> {

}
