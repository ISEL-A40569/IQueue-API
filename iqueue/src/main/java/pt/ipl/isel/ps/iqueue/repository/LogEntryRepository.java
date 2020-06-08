package pt.ipl.isel.ps.iqueue.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pt.ipl.isel.ps.iqueue.dao.LogEntryDao;

public interface LogEntryRepository extends JpaRepository<LogEntryDao, Integer> {
}
