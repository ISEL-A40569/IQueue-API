package pt.ipl.isel.ps.iqueue.model;

public class OperatorBeacon {

    private final int operatorId;
    private final int beaconId;

    public OperatorBeacon(int operatorId, int beaconId) {
        this.operatorId = operatorId;
        this.beaconId = beaconId;
    }

    public int getOperatorId() {
        return operatorId;
    }

    public int getBeaconId() {
        return beaconId;
    }
}
