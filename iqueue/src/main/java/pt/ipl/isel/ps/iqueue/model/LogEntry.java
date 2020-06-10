package pt.ipl.isel.ps.iqueue.model;

import java.time.LocalDateTime;

public class LogEntry {
    private final int logId;
    private final LocalDateTime logCreationDateTime;
    private final String requestMethod;
    private final String requestUri;
    private final String requestHeaders;
    private final String requestBody;
    private final int responseStatus;
    private final String responseHeaders;
    private final String responseBody;

    public LogEntry(int logId, LocalDateTime logCreationDateTime, String requestMethod, String requestUri, String requestHeaders, String requestBody, int responseStatus, String responseHeaders, String responseBody) {
        this.logId = logId;
        this.logCreationDateTime = logCreationDateTime;
        this.requestMethod = requestMethod;
        this.requestUri = requestUri;
        this.requestHeaders = requestHeaders;
        this.requestBody = requestBody;
        this.responseStatus = responseStatus;
        this.responseHeaders = responseHeaders;
        this.responseBody = responseBody;
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

    public String getRequestHeaders() {
        return requestHeaders;
    }

    public String getRequestBody() {
        return requestBody;
    }

    public int getResponseStatus() {
        return responseStatus;
    }

    public String getResponseHeaders() {
        return responseHeaders;
    }

    public String getResponseBody() {
        return responseBody;
    }
}
