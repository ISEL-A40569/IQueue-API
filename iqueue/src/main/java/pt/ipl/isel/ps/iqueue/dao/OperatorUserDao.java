package pt.ipl.isel.ps.iqueue.dao;

import pt.ipl.isel.ps.iqueue.dao.embeddable.OperatorUserIds;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "OperatorUser")
public class OperatorUserDao {

    @EmbeddedId
    private OperatorUserIds operatorUserIds;

    public OperatorUserDao() {
    }

    public OperatorUserDao(OperatorUserIds operatorUserIds) {
        this.operatorUserIds = operatorUserIds;
    }

    public OperatorUserIds getOperatorUserIds() {
        return operatorUserIds;
    }

    public void setOperatorUserIds(OperatorUserIds operatorUserIds) {
        this.operatorUserIds = operatorUserIds;
    }
}
