package pt.ipl.isel.ps.iqueue.model;

public class AttendanceStatus {
    private final int attendanceStatusId;
    private final int languageId;
    private final String attendanceStatusDescription;

    public AttendanceStatus(int attendanceStatusId, int languageId, String attendanceStatusDescription) {
        this.attendanceStatusId = attendanceStatusId;
        this.languageId = languageId;
        this.attendanceStatusDescription = attendanceStatusDescription;
    }

    public int getAttendanceStatusId() {
        return attendanceStatusId;
    }

    public int getLanguageId() {
        return languageId;
    }

    public String getAttendanceStatusDescription() {
        return attendanceStatusDescription;
    }
}
