package pt.ipl.isel.ps.iqueue.model;

import java.time.LocalDateTime;

public class AttendanceClassification {
    private final int attendanceId;
    private final LocalDateTime classificationCreationDateTime;
    private final int rate;
    private final String observations;

    public AttendanceClassification(int attendanceId, LocalDateTime classificationCreationDateTime, int rate, String observations) {
        this.attendanceId = attendanceId;
        this.classificationCreationDateTime = classificationCreationDateTime;
        this.rate = rate;
        this.observations = observations;
    }

    public int getAttendanceId() {
        return attendanceId;
    }

    public LocalDateTime getClassificationCreationDateTime() {
        return classificationCreationDateTime;
    }

    public int getRate() {
        return rate;
    }

    public String getObservations() {
        return observations;
    }
}
