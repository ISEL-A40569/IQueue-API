package pt.ipl.isel.ps.iqueue.model;

public class ServiceQueueDesk {
    private final int operatorId;
    private final int serviceQueueId;
    private final int deskId;

    public ServiceQueueDesk(int operatorId, int serviceQueueId, int deskId) {
        this.operatorId = operatorId;
        this.serviceQueueId = serviceQueueId;
        this.deskId = deskId;
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
}
