package pt.ipl.isel.ps.iqueue.model;

import java.time.LocalDateTime;

public class Attendance {
    private int attendanceId;
    private int operatorId;
    private int serviceQueueId;
    private int deskId;
    private int clientId;
    private LocalDateTime startWaitingTime;
    private LocalDateTime endWaitingTime;
    private LocalDateTime startAttendanceTime;
    private LocalDateTime endAttendanceTime;
    private int attendanceStatusId;
    private int attendanceUserId;

    public Attendance() {
    }

    public Attendance(int operatorId, int serviceQueueId, int deskId, int clientId, LocalDateTime startWaitingTime, int attendanceStatusId, int attendanceUserId) {
        this.operatorId = operatorId;
        this.serviceQueueId = serviceQueueId;
        this.deskId = deskId;
        this.clientId = clientId;
        this.startWaitingTime = startWaitingTime;
        this.attendanceStatusId = attendanceStatusId;
        this.attendanceUserId = attendanceUserId;
    }

    public Attendance(int attendanceId, int operatorId, int serviceQueueId, int deskId, int clientId, LocalDateTime startWaitingTime, LocalDateTime endWaitingTime, LocalDateTime startAttendanceTime, LocalDateTime endAttendanceTime, int attendanceStatusId, int attendanceUserId) {
        this.attendanceId = attendanceId;
        this.operatorId = operatorId;
        this.serviceQueueId = serviceQueueId;
        this.deskId = deskId;
        this.clientId = clientId;
        this.startWaitingTime = startWaitingTime;
        this.endWaitingTime = endWaitingTime;
        this.startAttendanceTime = startAttendanceTime;
        this.endAttendanceTime = endAttendanceTime;
        this.attendanceStatusId = attendanceStatusId;
        this.attendanceUserId = attendanceUserId;
    }

    public int getAttendanceId() {
        return attendanceId;
    }

    public void setAttendanceId(int attendanceId) {
        this.attendanceId = attendanceId;
    }

    public LocalDateTime getEndWaitingTime() {
        return endWaitingTime;
    }

    public void setEndWaitingTime(LocalDateTime endWaitingTime) {
        this.endWaitingTime = endWaitingTime;
    }

    public LocalDateTime getStartAttendanceTime() {
        return startAttendanceTime;
    }

    public void setStartAttendanceTime(LocalDateTime startAttendanceTime) {
        this.startAttendanceTime = startAttendanceTime;
    }

    public LocalDateTime getEndAttendanceTime() {
        return endAttendanceTime;
    }

    public void setEndAttendanceTime(LocalDateTime endAttendanceTime) {
        this.endAttendanceTime = endAttendanceTime;
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

    public int getClientId() {
        return clientId;
    }

    public LocalDateTime getStartWaitingTime() {
        return startWaitingTime;
    }

    public int getAttendanceStatusId() {
        return attendanceStatusId;
    }

    public int getAttendanceUserId() {
        return attendanceUserId;
    }
}
