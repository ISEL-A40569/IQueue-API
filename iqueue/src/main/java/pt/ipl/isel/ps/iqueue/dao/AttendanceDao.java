package pt.ipl.isel.ps.iqueue.dao;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Attendance")
public class AttendanceDao {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "attendanceId")
    private int attendanceId;

    @Column(name = "serviceQueueId")
    private int serviceQueueId;

    @Column(name = "deskId")
    private int deskId;

    @Column(name = "clientId")
    private int clientId;

    @Column(name = "startWaitingTime")
    private LocalDateTime startWaitingTime;

    @Column(name = "startAttendanceTime")
    private LocalDateTime startAttendanceTime;

    @Column(name = "endAttendanceTime")
    private LocalDateTime endAttendanceTime;

    @Column(name = "attendanceStatusId")
    private int attendanceStatusId;

    public AttendanceDao() {
    }

    public AttendanceDao(int attendanceId, int serviceQueueId, int deskId, int clientId, LocalDateTime startWaitingTime, LocalDateTime startAttendanceTime, LocalDateTime endAttendanceTime, int attendanceStatusId) {
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

    public void setAttendanceId(int attendanceId) {
        this.attendanceId = attendanceId;
    }

    public int getServiceQueueId() {
        return serviceQueueId;
    }

    public void setServiceQueueId(int serviceQueueId) {
        this.serviceQueueId = serviceQueueId;
    }

    public int getDeskId() {
        return deskId;
    }

    public void setDeskId(int deskId) {
        this.deskId = deskId;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public LocalDateTime getStartWaitingTime() {
        return startWaitingTime;
    }

    public void setStartWaitingTime(LocalDateTime startWaitingTime) {
        this.startWaitingTime = startWaitingTime;
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

    public int getAttendanceStatusId() {
        return attendanceStatusId;
    }

    public void setAttendanceStatusId(int attendanceStatusId) {
        this.attendanceStatusId = attendanceStatusId;
    }
}
