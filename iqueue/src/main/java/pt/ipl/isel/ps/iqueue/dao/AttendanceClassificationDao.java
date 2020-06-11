package pt.ipl.isel.ps.iqueue.dao;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "AttendanceClassification")
public class AttendanceClassificationDao {

    @Id
    @Column(name = "attendanceId")
    private int attendanceId;

    @Column(name = "classificationCreationDateTime")
    private LocalDateTime classificationCreationDateTime;

    @Column(name = "rate")
    private int rate;

    @Column(name = "observations")
    private String observations;

    public AttendanceClassificationDao() {
    }

    public AttendanceClassificationDao(int attendanceId, LocalDateTime classificationCreationDateTime, int rate, String observations) {
        this.attendanceId = attendanceId;
        this.classificationCreationDateTime = classificationCreationDateTime;
        this.rate = rate;
        this.observations = observations;
    }

    public int getAttendanceId() {
        return attendanceId;
    }

    public void setAttendanceId(int attendanceId) {
        this.attendanceId = attendanceId;
    }

    public LocalDateTime getClassificationCreationDateTime() {
        return classificationCreationDateTime;
    }

    public void setClassificationCreationDateTime(LocalDateTime classificationCreationDateTime) {
        this.classificationCreationDateTime = classificationCreationDateTime;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }
}
