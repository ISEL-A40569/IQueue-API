package pt.ipl.isel.ps.iqueue.model;

public class OperatorServiceQueue {
    private int operatorId;
    private int serviceQueueId;
    private String serviceQueueDescription;
    private int serviceQueueTypeId;
    private int dailyLimit;

    public OperatorServiceQueue() {
    }

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

    public void setOperatorId(int operatorId) {
        this.operatorId = operatorId;
    }

    public void setServiceQueueId(int serviceQueueId) {
        this.serviceQueueId = serviceQueueId;
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
