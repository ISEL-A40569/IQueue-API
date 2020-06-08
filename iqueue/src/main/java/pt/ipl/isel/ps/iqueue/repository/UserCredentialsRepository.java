package pt.ipl.isel.ps.iqueue.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import pt.ipl.isel.ps.iqueue.dao.UserCredentialsDao;

@Component
public interface UserCredentialsRepository extends JpaRepository<UserCredentialsDao, Integer> {
}
