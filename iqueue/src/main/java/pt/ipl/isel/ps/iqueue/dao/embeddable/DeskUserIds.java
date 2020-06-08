package pt.ipl.isel.ps.iqueue.dao.embeddable;

import javax.persistence.Embeddable;

@Embeddable
public class DeskUserIds {

    private int deskId;
    private int userId;

    public DeskUserIds() {
    }

    public DeskUserIds(int deskId, int userId) {
        this.deskId = deskId;
        this.userId = userId;
    }

    public int getDeskId() {
        return deskId;
    }

    public void setDeskId(int deskId) {
        this.deskId = deskId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
