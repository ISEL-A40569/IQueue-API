package pt.ipl.isel.ps.iqueue.model;

public class ServiceQueueCurrentAttendance {
    private final int currentAttendanceTicketNumber;

    public ServiceQueueCurrentAttendance(int currentAttendanceTicketNumber) {
        this.currentAttendanceTicketNumber = currentAttendanceTicketNumber;
    }

    public int getCurrentAttendanceTicketNumber() {
        return currentAttendanceTicketNumber;
    }
}
