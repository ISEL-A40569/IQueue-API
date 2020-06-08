package pt.ipl.isel.ps.iqueue.model;

import javax.persistence.Column;
import java.time.LocalDate;

public class DeskUser {
    private final int deskId;
    private final int userId;
    private final LocalDate startDate;
    private final LocalDate endDate;

    public DeskUser(int deskId, int userId, LocalDate startDate, LocalDate endDate) {
        this.deskId = deskId;
        this.userId = userId;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public int getDeskId() {
        return deskId;
    }

    public int getUserId() {
        return userId;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }
}
