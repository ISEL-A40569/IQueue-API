package pt.ipl.isel.ps.iqueue.dao;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "[Log]")
public class LogEntryDao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "logId")
    private int logId;

    @Column(name = "logCreationDateTime")
    private LocalDateTime logCreationDateTime;

    @Column(name = "requestMethod")
    private String requestMethod;

    @Column(name = "requestUri")
    private String requestUri;

    @Column(name = "responseStatus")
    private int responseStatus;

    public LogEntryDao() {
    }

    public LogEntryDao(int logId, LocalDateTime logCreationDateTime, String requestMethod, String requestUri, int responseStatus) {
        this.logId = logId;
        this.logCreationDateTime = logCreationDateTime;
        this.requestMethod = requestMethod;
        this.requestUri = requestUri;
        this.responseStatus = responseStatus;
    }

    public int getLogId() {
        return logId;
    }

    public void setLogId(int logId) {
        this.logId = logId;
    }

    public LocalDateTime getLogCreationDateTime() {
        return logCreationDateTime;
    }

    public void setLogCreationDateTime(LocalDateTime logCreationDateTime) {
        this.logCreationDateTime = logCreationDateTime;
    }

    public String getRequestMethod() {
        return requestMethod;
    }

    public void setRequestMethod(String requestMethod) {
        this.requestMethod = requestMethod;
    }

    public String getRequestUri() {
        return requestUri;
    }

    public void setRequestUri(String requestUri) {
        this.requestUri = requestUri;
    }

    public int getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(int responseStatus) {
        this.responseStatus = responseStatus;
    }


}
