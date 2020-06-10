package pt.ipl.isel.ps.iqueue.model;

import java.time.LocalDateTime;

public class Attendance {
    private final int attendanceId;
    private final int serviceQueueId;
    private final int deskId;
    private final int clientId;
    private final LocalDateTime startWaitingTime;
    private final LocalDateTime startAttendanceTime;
    private final LocalDateTime endAttendanceTime;
    private final int attendanceStatusId;

    public Attendance(int attendanceId, int serviceQueueId, int deskId, int clientId, LocalDateTime startWaitingTime, LocalDateTime startAttendanceTime, LocalDateTime endAttendanceTime, int attendanceStatusId) {
        this.attendanceId = attendanceId;
        this.serviceQueueId = serviceQueueId;
        this.deskId = deskId;
        this.clientId = clientId;
        this.startWaitingTime = startWaitingTime;
        this.startAttendanceTime = startAttendanceTime;
        this.endAttendanceTime = endAttendanceTime;
        this.attendanceStatusId = attendanceStatusId;
    }

    public int getAttendanceId() {
        return attendanceId;
    }

    public int getServiceQueueId() {
        return serviceQueueId;
    }

    public int getDeskId() {
        return deskId;
    }

    public int getClientId() {
        return clientId;
    }

    public LocalDateTime getStartWaitingTime() {
        return startWaitingTime;
    }

    public LocalDateTime getStartAttendanceTime() {
        return startAttendanceTime;
    }

    public LocalDateTime getEndAttendanceTime() {
        return endAttendanceTime;
    }

    public int getAttendanceStatusId() {
        return attendanceStatusId;
    }
}
