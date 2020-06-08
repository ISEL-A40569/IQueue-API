package pt.ipl.isel.ps.iqueue.dao.embeddable;

import javax.persistence.Embeddable;

@Embeddable
public class OperatorBeaconIds {
    private int operatorId;
    private int beaconId;

    public OperatorBeaconIds() {
    }

    public OperatorBeaconIds(int operatorId, int beaconId) {
        this.operatorId = operatorId;
        this.beaconId = beaconId;
    }

    public int getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(int operatorId) {
        this.operatorId = operatorId;
    }

    public int getBeaconId() {
        return beaconId;
    }

    public void setBeaconId(int beaconId) {
        this.beaconId = beaconId;
    }
}
