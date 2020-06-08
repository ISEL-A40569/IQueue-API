package pt.ipl.isel.ps.iqueue.model;

import javax.persistence.Column;
import java.time.LocalDate;

public class OperatorBeacon {
    private final int operatorId;
    private final int beaconId;
    private final LocalDate startDate;
    private final LocalDate endDate;

    public OperatorBeacon(int operatorId, int beaconId, LocalDate startDate, LocalDate endDate) {
        this.operatorId = operatorId;
        this.beaconId = beaconId;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public int getOperatorId() {
        return operatorId;
    }

    public int getBeaconId() {
        return beaconId;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }
}
