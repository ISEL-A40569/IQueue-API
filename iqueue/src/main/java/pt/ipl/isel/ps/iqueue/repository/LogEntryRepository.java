package pt.ipl.isel.ps.iqueue.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pt.ipl.isel.ps.iqueue.model.LogEntry;

public interface LogEntryRepository extends JpaRepository<LogEntry, Integer> {
}
