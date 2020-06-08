package pt.ipl.isel.ps.iqueue.dao;

import pt.ipl.isel.ps.iqueue.dao.embeddable.OperatorBeaconIds;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "OperatorBeacon")
public class OperatorBeaconDao {

    @EmbeddedId
    private OperatorBeaconIds operatorBeaconIds;

    @Column(name = "startDate")
    private LocalDate startDate;

    @Column(name = "endDate")
    private LocalDate endDate;

    public OperatorBeaconDao() {
    }

    public OperatorBeaconDao(OperatorBeaconIds operatorBeaconIds, LocalDate startDate, LocalDate endDate) {
        this.operatorBeaconIds = operatorBeaconIds;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public OperatorBeaconIds getOperatorBeaconIds() {
        return operatorBeaconIds;
    }

    public void setOperatorBeaconIds(OperatorBeaconIds operatorBeaconIds) {
        this.operatorBeaconIds = operatorBeaconIds;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}
