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

    @Column(name = "startWaitingDateTime")
    private LocalDateTime startWaitingDateTime;

    @Column(name = "startAttendanceDateTime")
    private LocalDateTime startAttendanceDateTime;

    @Column(name = "endAttendanceDateTime")
    private LocalDateTime endAttendanceDateTime;

    @Column(name = "attendanceStatusId")
    private int attendanceStatusId;

    public AttendanceDao() {
    }

    public AttendanceDao(int attendanceId, int serviceQueueId, int deskId, int clientId, LocalDateTime startWaitingDateTime, LocalDateTime startAttendanceDateTime, LocalDateTime endAttendanceDateTime, int attendanceStatusId) {
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

    public LocalDateTime getStartWaitingDateTime() {
        return startWaitingDateTime;
    }

    public void setStartWaitingDateTime(LocalDateTime startWaitingDateTime) {
        this.startWaitingDateTime = startWaitingDateTime;
    }

    public LocalDateTime getStartAttendanceDateTime() {
        return startAttendanceDateTime;
    }

    public void setStartAttendanceDateTime(LocalDateTime startAttendanceDateTime) {
        this.startAttendanceDateTime = startAttendanceDateTime;
    }

    public LocalDateTime getEndAttendanceDateTime() {
        return endAttendanceDateTime;
    }

    public void setEndAttendanceDateTime(LocalDateTime endAttendanceDateTime) {
        this.endAttendanceDateTime = endAttendanceDateTime;
    }

    public int getAttendanceStatusId() {
        return attendanceStatusId;
    }

    public void setAttendanceStatusId(int attendanceStatusId) {
        this.attendanceStatusId = attendanceStatusId;
    }
}
