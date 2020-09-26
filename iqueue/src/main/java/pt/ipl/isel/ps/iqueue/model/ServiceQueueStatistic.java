package pt.ipl.isel.ps.iqueue.model;

import java.time.LocalTime;

public class ServiceQueueStatistic {

    int attendanceCount;

    LocalTime averageWaitingTime;

    LocalTime averageAttendanceTime;

    float averageRate;

    int quitCount;

    public ServiceQueueStatistic(int attendanceCount, int averageWaitingSeconds, int averageAttendanceSeconds, float averageRate, int quitCount) {
        this.attendanceCount = attendanceCount;
        this.averageWaitingTime = LocalTime.ofSecondOfDay(averageWaitingSeconds);
        this.averageAttendanceTime = LocalTime.ofSecondOfDay(averageAttendanceSeconds);
        this.averageRate = averageRate;
        this.quitCount = quitCount;
    }

    public int getAttendanceCount() {
        return attendanceCount;
    }

    public void setAttendanceCount(int attendanceCount) {
        this.attendanceCount = attendanceCount;
    }

    public LocalTime getAverageWaitingTime() {
        return averageWaitingTime;
    }

    public void setAverageWaitingTime(LocalTime averageWaitingTime) {
        this.averageWaitingTime = averageWaitingTime;
    }

    public LocalTime getAverageAttendanceTime() {
        return averageAttendanceTime;
    }

    public void setAverageAttendanceTime(LocalTime averageAttendanceTime) {
        this.averageAttendanceTime = averageAttendanceTime;
    }

    public float getAverageRate() {
        return averageRate;
    }

    public void setAverageRate(float averageRate) {
        this.averageRate = averageRate;
    }

    public int getQuitCount() {
        return quitCount;
    }

    public void setQuitCount(int quitCount) {
        this.quitCount = quitCount;
    }
}
