package pt.ipl.isel.ps.iqueue.dao;

import pt.ipl.isel.ps.iqueue.dao.embeddable.DeskUserIds;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "DeskUser")
public class DeskUserDao {

    @EmbeddedId
    private DeskUserIds deskUserIds;

    public DeskUserDao() {
    }

    public DeskUserDao(DeskUserIds deskUserIds) {
        this.deskUserIds = deskUserIds;
    }

    public DeskUserIds getDeskUserIds() {
        return deskUserIds;
    }

    public void setDeskUserIds(DeskUserIds deskUserIds) {
        this.deskUserIds = deskUserIds;
    }

}
