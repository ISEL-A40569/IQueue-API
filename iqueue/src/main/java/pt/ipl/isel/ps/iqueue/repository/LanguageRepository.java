package pt.ipl.isel.ps.iqueue.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import pt.ipl.isel.ps.iqueue.dao.LanguageDao;

@Component
public interface LanguageRepository extends JpaRepository<LanguageDao, Integer> {

}
