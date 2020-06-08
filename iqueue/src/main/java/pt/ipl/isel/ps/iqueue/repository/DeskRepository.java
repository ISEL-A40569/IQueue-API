package pt.ipl.isel.ps.iqueue.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import pt.ipl.isel.ps.iqueue.dao.DeskDao;

@Component
public interface DeskRepository extends JpaRepository<DeskDao, Integer> {

}
