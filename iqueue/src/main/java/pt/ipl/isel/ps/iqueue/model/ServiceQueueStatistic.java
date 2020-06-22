package pt.ipl.isel.ps.iqueue.model;

public class ServiceQueueStatistic {

    int attendanceCount;

    int averageWaitingSeconds;

    int averageAttendanceSeconds;

    int averageRate;

    int quitCount;

    public ServiceQueueStatistic(int attendanceCount, int averageWaitingSeconds, int averageAttendanceSeconds, int averageRate, int quitCount) {
        this.attendanceCount = attendanceCount;
        this.averageWaitingSeconds = averageWaitingSeconds;
        this.averageAttendanceSeconds = averageAttendanceSeconds;
        this.averageRate = averageRate;
        this.quitCount = quitCount;
    }

    public int getAttendanceCount() {
        return attendanceCount;
    }

    public void setAttendanceCount(int attendanceCount) {
        this.attendanceCount = attendanceCount;
    }

    public int getAverageWaitingSeconds() {
        return averageWaitingSeconds;
    }

    public void setAverageWaitingSeconds(int averageWaitingSeconds) {
        this.averageWaitingSeconds = averageWaitingSeconds;
    }

    public int getAverageAttendanceSeconds() {
        return averageAttendanceSeconds;
    }

    public void setAverageAttendanceSeconds(int averageAttendanceSeconds) {
        this.averageAttendanceSeconds = averageAttendanceSeconds;
    }

    public int getAverageRate() {
        return averageRate;
    }

    public void setAverageRate(int averageRate) {
        this.averageRate = averageRate;
    }

    public int getQuitCount() {
        return quitCount;
    }

    public void setQuitCount(int quitCount) {
        this.quitCount = quitCount;
    }
}
