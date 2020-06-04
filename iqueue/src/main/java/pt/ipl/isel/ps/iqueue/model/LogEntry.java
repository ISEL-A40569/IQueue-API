package pt.ipl.isel.ps.iqueue.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "LogEntry")
public class LogEntry {

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

    @Column(name = "requestHeaders")
    private String requestHeaders;

    @Column(name = "requestBody")
    private String requestBody;

    @Column(name = "responseStatus")
    private int responseStatus;

    @Column(name = "responseHeaders")
    private String responseHeaders;

    @Column(name = "responseBody")
    private String responseBody;

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

    public String getRequestHeaders() {
        return requestHeaders;
    }

    public void setRequestHeaders(String requestHeaders) {
        this.requestHeaders = requestHeaders;
    }

    public String getRequestBody() {
        return requestBody;
    }

    public void setRequestBody(String requestBody) {
        this.requestBody = requestBody;
    }

    public int getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(int responseStatus) {
        this.responseStatus = responseStatus;
    }

    public String getResponseHeaders() {
        return responseHeaders;
    }

    public void setResponseHeaders(String responseHeaders) {
        this.responseHeaders = responseHeaders;
    }

    public String getResponseBody() {
        return responseBody;
    }

    public void setResponseBody(String responseBody) {
        this.responseBody = responseBody;
    }
}
