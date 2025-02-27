package pt.ipl.isel.ps.iqueue.dao.keys;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class AttendanceStatusIds implements Serializable {
    private int attendanceStatusId;
    private int languageId;

    public AttendanceStatusIds() {
    }

    public AttendanceStatusIds(int attendanceStatusId, int languageId) {
        this.attendanceStatusId = attendanceStatusId;
        this.languageId = languageId;
    }

    public int getAttendanceStatusId() {
        return attendanceStatusId;
    }

    public void setAttendanceStatusId(int attendanceStatusId) {
        this.attendanceStatusId = attendanceStatusId;
    }

    public int getLanguageId() {
        return languageId;
    }

    public void setLanguageId(int languageId) {
        this.languageId = languageId;
    }
}
