package pt.ipl.isel.ps.iqueue.model;

public class ServiceQueue {
    private int serviceQueueId;
    private int operatorId;
    private String serviceQueueDescription;
    private int serviceQueueTypeId;
    private int dailyLimit;

    public ServiceQueue(int serviceQueueId, int operatorId, String serviceQueueDescription, int serviceQueueTypeId, int dailyLimit) {
        this.serviceQueueId = serviceQueueId;
        this.operatorId = operatorId;
        this.serviceQueueDescription = serviceQueueDescription;
        this.serviceQueueTypeId = serviceQueueTypeId;
        this.dailyLimit = dailyLimit;
    }

    public int getServiceQueueId() {
        return serviceQueueId;
    }

    public int getOperatorId() {
        return operatorId;
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

    public void setServiceQueueId(int serviceQueueId) {
        this.serviceQueueId = serviceQueueId;
    }

    public void setOperatorId(int operatorId) {
        this.operatorId = operatorId;
    }

    public void setServiceQueueDescription(String serviceQueueDescription) {
        this.serviceQueueDescription = serviceQueueDescription;
    }

    public void setServiceQueueTypeId(int serviceQueueTypeId) {
        this.serviceQueueTypeId = serviceQueueTypeId;
    }

    public void setDailyLimit(int dailyLimit) {
        this.dailyLimit = dailyLimit;
    }
}
