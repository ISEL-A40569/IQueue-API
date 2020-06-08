package pt.ipl.isel.ps.iqueue.repository;

import org.springframework.data.repository.Repository;
import org.springframework.stereotype.Component;
import pt.ipl.isel.ps.iqueue.dao.AttendanceStatusDao;
import pt.ipl.isel.ps.iqueue.dao.embeddable.AttendanceStatusIds;


@Component
public interface AttendanceStatusRepository extends Repository<AttendanceStatusDao, AttendanceStatusIds> {

}
