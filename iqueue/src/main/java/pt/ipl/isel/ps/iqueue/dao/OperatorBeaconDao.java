package pt.ipl.isel.ps.iqueue.dao;

import pt.ipl.isel.ps.iqueue.dao.embeddable.OperatorBeaconIds;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "OperatorBeacon")
public class OperatorBeaconDao {

    @EmbeddedId
    private OperatorBeaconIds operatorBeaconIds;

    public OperatorBeaconDao() {
    }

    public OperatorBeaconDao(OperatorBeaconIds operatorBeaconIds) {
        this.operatorBeaconIds = operatorBeaconIds;
    }

    public OperatorBeaconIds getOperatorBeaconIds() {
        return operatorBeaconIds;
    }

    public void setOperatorBeaconIds(OperatorBeaconIds operatorBeaconIds) {
        this.operatorBeaconIds = operatorBeaconIds;
    }

}
