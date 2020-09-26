package pt.ipl.isel.ps.iqueue.dao.keys;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class OperatorUserIds implements Serializable {
    private int operatorId;
    private int userId;

    public OperatorUserIds() {
    }

    public OperatorUserIds(int operatorId, int userId) {
        this.operatorId = operatorId;
        this.userId = userId;
    }

    public int getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(int operatorId) {
        this.operatorId = operatorId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
