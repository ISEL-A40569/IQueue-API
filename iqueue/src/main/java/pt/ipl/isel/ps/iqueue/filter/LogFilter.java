package pt.ipl.isel.ps.iqueue.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.filter.OncePerRequestFilter;
import pt.ipl.isel.ps.iqueue.model.LogEntry;
import pt.ipl.isel.ps.iqueue.repository.LogEntryRepository;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

public class LogFilter extends OncePerRequestFilter {

    @Autowired
    private final LogEntryRepository logEntryRepository;

    public LogFilter(LogEntryRepository logEntryRepository) {
        this.logEntryRepository = logEntryRepository;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        LogEntry logEntry = new LogEntry();

        logEntry.setLogCreationDateTime(LocalDateTime.now());
        logEntry.setRequestMethod(request.getMethod());
        logEntry.setRequestUri(request.getRequestURI());
//        logEntry.setRequestHeaders(request.getHeaders()); // TODO: how to get all of them?
//        logEntry.setRequestBody(request.);    // TODO: how to get body?
        logEntry.setResponseStatus(response.getStatus());
//        logEntry.setResponseHeaders(response.getHeaders());   // TODO: how to get all of them?
//        logEntry.setResponseBody(response.get);   // TODO: how to get body?

        logEntryRepository.save(logEntry);
    }
}
