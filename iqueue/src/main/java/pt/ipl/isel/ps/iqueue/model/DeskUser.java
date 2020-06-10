package pt.ipl.isel.ps.iqueue.model;

public class DeskUser {
    private final int deskId;
    private final int userId;

    public DeskUser(int deskId, int userId) {
        this.deskId = deskId;
        this.userId = userId;
    }

    public int getDeskId() {
        return deskId;
    }

    public int getUserId() {
        return userId;
    }

}
