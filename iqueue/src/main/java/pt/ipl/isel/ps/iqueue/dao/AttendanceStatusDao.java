package pt.ipl.isel.ps.iqueue.dao;

import pt.ipl.isel.ps.iqueue.dao.embeddable.AttendanceStatusIds;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "AttendanceStatus")
public class AttendanceStatusDao {

    @EmbeddedId
    private AttendanceStatusIds attendanceStatusId;

    @Column(name = "attendanceStatusDescription")
    private String attendanceStatusDescription;

    public AttendanceStatusDao() {
    }

    public AttendanceStatusDao(AttendanceStatusIds attendanceStatusId, String attendanceStatusDescription) {
        this.attendanceStatusId = attendanceStatusId;
        this.attendanceStatusDescription = attendanceStatusDescription;
    }

    public AttendanceStatusIds getAttendanceStatusIds() {
        return attendanceStatusId;
    }

    public void setAttendanceStatusIds(AttendanceStatusIds attendanceStatusId) {
        this.attendanceStatusId = attendanceStatusId;
    }

    public String getAttendanceStatusDescription() {
        return attendanceStatusDescription;
    }

    public void setAttendanceStatusDescription(String attendanceStatusDescription) {
        this.attendanceStatusDescription = attendanceStatusDescription;
    }
}
