package pt.ipl.isel.ps.iqueue.model;

public class Desk {
    private int deskId;
    private int serviceQueueId;
    private String deskDescription;

    public Desk(int deskId, int serviceQueueId, String deskDescription) {
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
