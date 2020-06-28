package pt.ipl.isel.ps.iqueue.dao;

import javax.persistence.*;

@Entity
@Table(name = "AttendanceTicket")
public class AttendanceTicketDao {

    @Id
    @Column(name = "attendanceId")
    private int attendanceId;

    @Column(name = "ticketNumber")
    private int ticketNumber;

    public AttendanceTicketDao() {
    }

    public AttendanceTicketDao(int attendanceId, int ticketNumber) {
        this.attendanceId = attendanceId;
        this.ticketNumber = ticketNumber;
    }

    public int getAttendanceId() {
        return attendanceId;
    }

    public void setAttendanceId(int attendanceId) {
        this.attendanceId = attendanceId;
    }

    public int getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(int ticketNumber) {
        this.ticketNumber = ticketNumber;
    }
}
