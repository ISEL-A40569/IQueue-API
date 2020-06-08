package pt.ipl.isel.ps.iqueue.model;

import javax.persistence.Column;

public class ServiceQueue {
    private final int serviceQueueId;
    private final int operatorId;
    private final String serviceQueueDescription;
    private final int serviceQueueTypeId;
    private final int dailyLimit;

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
}
