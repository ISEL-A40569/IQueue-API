package pt.ipl.isel.ps.iqueue.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pt.ipl.isel.ps.iqueue.dao.AttendanceTicketDao;
import pt.ipl.isel.ps.iqueue.model.AttendanceTicket;

import javax.persistence.criteria.CriteriaBuilder;

public interface AttendanceTicketRepository extends JpaRepository<AttendanceTicketDao, Integer> {
}
