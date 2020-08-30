package pt.ipl.isel.ps.iqueue.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import pt.ipl.isel.ps.iqueue.dao.DeskUserDao;
import pt.ipl.isel.ps.iqueue.dao.embeddable.DeskUserIds;


@Component
public interface DeskUserRepository extends JpaRepository<DeskUserDao, DeskUserIds> {

    void deleteByDeskUserIdsDeskId(int deskId);

    void deleteByDeskUserIdsUserId(int userId);
}
