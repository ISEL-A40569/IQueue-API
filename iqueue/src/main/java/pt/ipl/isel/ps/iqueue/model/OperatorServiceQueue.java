package pt.ipl.isel.ps.iqueue.model;

public class OperatorServiceQueue {
    private final int operatorId;
    private final int serviceQueueId;
    private final String serviceQueueDescription;
    private final int serviceQueueTypeId;
    private final int dailyLimit;

    public OperatorServiceQueue(int operatorId, int serviceQueueId, String serviceQueueDescription, int serviceQueueTypeId, int dailyLimit) {
        this.operatorId = operatorId;
        this.serviceQueueId = serviceQueueId;
        this.serviceQueueDescription = serviceQueueDescription;
        this.serviceQueueTypeId = serviceQueueTypeId;
        this.dailyLimit = dailyLimit;
    }

    public int getOperatorId() {
        return operatorId;
    }

    public int getServiceQueueId() {
        return serviceQueueId;
    }

    public String getServiceQueueDescription() {
        return serviceQueueDescription;
    }

    public int getServiceQueueTypeId() {
        return serviceQueueTypeId;
    }

    public int getDailyLimit() {
        return dailyLimit;
    }
}
