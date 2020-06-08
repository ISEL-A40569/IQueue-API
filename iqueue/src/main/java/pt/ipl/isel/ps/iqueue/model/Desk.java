package pt.ipl.isel.ps.iqueue.model;

import javax.persistence.Column;

public class Desk {
    private final int deskId;
    private final int serviceQueueId;
    private final String deskDescription;

    public Desk(int deskId, int serviceQueueId, String deskDescription) {
        this.deskId = deskId;
        this.serviceQueueId = serviceQueueId;
        this.deskDescription = deskDescription;
    }

    public int getDeskId() {
        return deskId;
    }

    public int getServiceQueueId() {
        return serviceQueueId;
    }

    public String getDeskDescription() {
        return deskDescription;
    }
}
