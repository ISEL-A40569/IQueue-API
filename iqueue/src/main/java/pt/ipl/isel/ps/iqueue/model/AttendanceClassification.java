package pt.ipl.isel.ps.iqueue.model;

import java.time.LocalDateTime;

public class AttendanceClassification {
    private final int attendanceId;
    private final LocalDateTime classificationCreationTime;
    private final int rate;
    private final String observations;

    public AttendanceClassification(int attendanceId, LocalDateTime classificationCreationTime, int rate, String observations) {
        this.attendanceId = attendanceId;
        this.classificationCreationTime = classificationCreationTime;
        this.rate = rate;
        this.observations = observations;
    }

    public int getAttendanceId() {
        return attendanceId;
    }

    public LocalDateTime getClassificationCreationTime() {
        return classificationCreationTime;
    }

    public int getRate() {
        return rate;
    }

    public String getObservations() {
        return observations;
    }
}
