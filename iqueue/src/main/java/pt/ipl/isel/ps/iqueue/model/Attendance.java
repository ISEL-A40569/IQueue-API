package pt.ipl.isel.ps.iqueue.model;

import java.time.LocalDateTime;

public class Attendance {
    private int attendanceId;
    private int serviceQueueId;
    private Integer deskId;
    private int clientId;
    private LocalDateTime startWaitingDateTime;
    private LocalDateTime startAttendanceDateTime;
    private LocalDateTime endAttendanceDateTime;
    private int attendanceStatusId;

    public Attendance(int attendanceId, int serviceQueueId, Integer deskId, int clientId, LocalDateTime startWaitingDateTime, LocalDateTime startAttendanceDateTime, LocalDateTime endAttendanceDateTime, int attendanceStatusId) {
        this.attendanceId = attendanceId;
        this.serviceQueueId = serviceQueueId;
        this.deskId = deskId;
        this.clientId = clientId;
        this.startWaitingDateTime = startWaitingDateTime;
        this.startAttendanceDateTime = startAttendanceDateTime;
        this.endAttendanceDateTime = endAttendanceDateTime;
        this.attendanceStatusId = attendanceStatusId;
    }

    public int getAttendanceId() {
        return attendanceId;
    }

    public int getServiceQueueId() {
        return serviceQueueId;
    }

    public Integer getDeskId() {
        return deskId;
    }

    public int getClientId() {
        return clientId;
    }

    public LocalDateTime getStartWaitingDateTime() {
        return startWaitingDateTime;
    }

    public LocalDateTime getStartAttendanceDateTime() {
        return startAttendanceDateTime;
    }

    public LocalDateTime getEndAttendanceDateTime() {
        return endAttendanceDateTime;
    }

    public int getAttendanceStatusId() {
        return attendanceStatusId;
    }

    public void setAttendanceId(int attendanceId) {
        this.attendanceId = attendanceId;
    }
}
