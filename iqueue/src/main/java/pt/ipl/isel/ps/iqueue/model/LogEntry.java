package pt.ipl.isel.ps.iqueue.model;

import java.time.LocalDateTime;

public class LogEntry {
    private final int logId;
    private final LocalDateTime logCreationDateTime;
    private final String requestMethod;
    private final String requestUri;
    private final int responseStatus;

    public LogEntry(int logId, LocalDateTime logCreationDateTime, String requestMethod, String requestUri, int responseStatus) {
        this.logId = logId;
        this.logCreationDateTime = logCreationDateTime;
        this.requestMethod = requestMethod;
        this.requestUri = requestUri;
        this.responseStatus = responseStatus;
    }


    public int getLogId() {
        return logId;
    }

    public LocalDateTime getLogCreationDateTime() {
        return logCreationDateTime;
    }

    public String getRequestMethod() {
        return requestMethod;
    }

    public String getRequestUri() {
        return requestUri;
    }

    public int getResponseStatus() {
        return responseStatus;
    }

}
