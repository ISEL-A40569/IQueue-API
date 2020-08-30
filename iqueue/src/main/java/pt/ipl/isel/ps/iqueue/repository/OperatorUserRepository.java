package pt.ipl.isel.ps.iqueue.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import pt.ipl.isel.ps.iqueue.dao.OperatorUserDao;
import pt.ipl.isel.ps.iqueue.dao.embeddable.OperatorUserIds;

@Component
public interface OperatorUserRepository extends JpaRepository<OperatorUserDao, OperatorUserIds> {

    void deleteByOperatorUserIdsOperatorId(int operatorId);

    void deleteByOperatorUserIdsUserId(int userId);
}
