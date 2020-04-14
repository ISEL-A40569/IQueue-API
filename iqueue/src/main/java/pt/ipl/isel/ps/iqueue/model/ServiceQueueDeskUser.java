package pt.ipl.isel.ps.iqueue.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ServiceQueueDeskUser {

    private final int operatorId;
    private final int serviceQueueId;
    private final int deskId;
    private final int userId;
    private final LocalDate date;

    public ServiceQueueDeskUser(int operatorId, int serviceQueueId, int deskId, int userId, LocalDate date) {
        this.operatorId = operatorId;
        this.serviceQueueId = serviceQueueId;
        this.deskId = deskId;
        this.userId = userId;
        this.date = date;
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

    public int getUserId() {
        return userId;
    }

    public LocalDate getDate() {
        return date;
    }
}
