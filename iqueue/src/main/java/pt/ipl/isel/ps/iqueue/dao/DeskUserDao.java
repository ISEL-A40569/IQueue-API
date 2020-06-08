package pt.ipl.isel.ps.iqueue.dao;

import pt.ipl.isel.ps.iqueue.dao.embeddable.DeskUserIds;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "DeskUser")
public class DeskUserDao {

    @EmbeddedId
    private DeskUserIds deskUserIds;

    @Column(name = "startDate")
    private LocalDate startDate;

    @Column(name = "endDate")
    private LocalDate endDate;

    public DeskUserDao() {
    }

    public DeskUserDao(DeskUserIds deskUserIds, LocalDate startDate, LocalDate endDate) {
        this.deskUserIds = deskUserIds;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public DeskUserIds getDeskUserIds() {
        return deskUserIds;
    }

    public void setDeskUserIds(DeskUserIds deskUserIds) {
        this.deskUserIds = deskUserIds;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}
