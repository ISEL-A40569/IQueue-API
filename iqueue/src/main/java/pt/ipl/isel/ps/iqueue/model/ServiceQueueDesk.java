package pt.ipl.isel.ps.iqueue.model;

public class ServiceQueueDesk {
    private int operatorId;
    private int serviceQueueId;
    private int deskId;
    private String deskDescription;

    public ServiceQueueDesk() {
    }

    public ServiceQueueDesk(int operatorId, int serviceQueueId, int deskId, String deskDescription) {
        this.operatorId = operatorId;
        this.serviceQueueId = serviceQueueId;
        this.deskId = deskId;
        this.deskDescription = deskDescription;
    }

    public int getOperatorId() {
        return operatorId;
    }

    public int getServiceQueueId() {
        return serviceQueueId;
    }

    public int getDeskId() {
        return deskId;
    }

    public void setDeskId(int deskId) {
        this.deskId = deskId;
    }

    public String getDeskDescription() {
        return deskDescription;
    }
}
