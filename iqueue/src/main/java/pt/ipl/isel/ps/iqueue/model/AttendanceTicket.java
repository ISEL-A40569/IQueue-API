package pt.ipl.isel.ps.iqueue.model;

public class AttendanceTicket {
    private int attendanceId;

    private int ticketNumber;

    public AttendanceTicket(int attendanceId, int ticketNumber) {
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
