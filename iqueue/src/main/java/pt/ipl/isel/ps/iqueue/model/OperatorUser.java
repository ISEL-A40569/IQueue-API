package pt.ipl.isel.ps.iqueue.model;

public class OperatorUser {

    private final int operatorId;
    private final  int userId;

    public OperatorUser(int operatorId, int userId) {
        this.operatorId = operatorId;
        this.userId = userId;
    }

    public int getOperatorId() {
        return operatorId;
    }

    public int getUserId() {
        return userId;
    }
}
