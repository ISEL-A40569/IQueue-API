package pt.ipl.isel.ps.iqueue.dao;

import javax.persistence.*;

@Entity
@Table(name = "Desk")
public class DeskDao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "deskId")
    private int deskId;

    @Column(name = "serviceQueueId")
    private int serviceQueueId;

    @Column(name = "deskDescription")
    private String deskDescription;

    public DeskDao() {
    }

    public DeskDao(int deskId, int serviceQueueId, String deskDescription) {
        this.deskId = deskId;
        this.serviceQueueId = serviceQueueId;
        this.deskDescription = deskDescription;
    }

    public int getDeskId() {
        return deskId;
    }

    public void setDeskId(int deskId) {
        this.deskId = deskId;
    }

    public int getServiceQueueId() {
        return serviceQueueId;
    }

    public void setServiceQueueId(int serviceQueueId) {
        this.serviceQueueId = serviceQueueId;
    }

    public String getDeskDescription() {
        return deskDescription;
    }

    public void setDeskDescription(String deskDescription) {
        this.deskDescription = deskDescription;
    }
}
