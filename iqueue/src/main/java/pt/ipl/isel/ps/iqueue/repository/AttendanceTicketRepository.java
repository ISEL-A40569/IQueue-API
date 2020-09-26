package pt.ipl.isel.ps.iqueue.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pt.ipl.isel.ps.iqueue.dao.AttendanceTicketDao;

public interface AttendanceTicketRepository extends JpaRepository<AttendanceTicketDao, Integer> {

    void deleteByAttendanceId(int attendanceId);
}
