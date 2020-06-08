package pt.ipl.isel.ps.iqueue.dao;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "AttendanceClassification")
public class AttendanceClassificationDao {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "attendanceId")
    private int attendanceId;

    @Column(name = "classificationCreationTime")
    private LocalDateTime classificationCreationTime;

    @Column(name = "rate")
    private int rate;

    @Column(name = "observations")
    private String observations;

    public AttendanceClassificationDao() {
    }

    public AttendanceClassificationDao(int attendanceId, LocalDateTime classificationCreationTime, int rate, String observations) {
        this.attendanceId = attendanceId;
        this.classificationCreationTime = classificationCreationTime;
        this.rate = rate;
        this.observations = observations;
    }

    public int getAttendanceId() {
        return attendanceId;
    }

    public void setAttendanceId(int attendanceId) {
        this.attendanceId = attendanceId;
    }

    public LocalDateTime getClassificationCreationTime() {
        return classificationCreationTime;
    }

    public void setClassificationCreationTime(LocalDateTime classificationCreationTime) {
        this.classificationCreationTime = classificationCreationTime;
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
