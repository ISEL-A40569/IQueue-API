package pt.ipl.isel.ps.iqueue.model;

public class ServiceQueueWaitingCount {

    private int waitingCount;

    public ServiceQueueWaitingCount(int waitingCount) {
        this.waitingCount = waitingCount;
    }

    public int getWaitingCount() {
        return waitingCount;
    }
}
