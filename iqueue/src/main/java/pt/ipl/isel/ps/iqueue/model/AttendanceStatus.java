package pt.ipl.isel.ps.iqueue.model;

public class AttendanceStatus {
    private int attendanceStatusId;
    private int languageId;
    private String attendanceStatusDescription;

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

    public void setAttendanceStatusId(int attendanceStatusId) {
        this.attendanceStatusId = attendanceStatusId;
    }

    public void setLanguageId(int languageId) {
        this.languageId = languageId;
    }

    public void setAttendanceStatusDescription(String attendanceStatusDescription) {
        this.attendanceStatusDescription = attendanceStatusDescription;
    }
}
