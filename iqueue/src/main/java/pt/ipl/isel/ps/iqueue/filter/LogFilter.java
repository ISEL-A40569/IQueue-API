package pt.ipl.isel.ps.iqueue.filter;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.util.ContentCachingRequestWrapper;
import pt.ipl.isel.ps.iqueue.dao.LogEntryDao;
import pt.ipl.isel.ps.iqueue.repository.LogEntryRepository;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

import static java.nio.charset.StandardCharsets.UTF_8;


@Component
public class LogFilter implements Filter {

    @Autowired
    private final LogEntryRepository logEntryRepository;

    public LogFilter(LogEntryRepository logEntryRepository) {
        this.logEntryRepository = logEntryRepository;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        ContentCachingRequestWrapper requestWrapper = new ContentCachingRequestWrapper(req);

        chain.doFilter(req, res);

        if (!req.getMethod().equals(HttpMethod.OPTIONS.name()) &&
                !req.getMethod().equals(HttpMethod.GET.name())) {
            LogEntryDao logEntry = new LogEntryDao();

            logEntry.setLogCreationDateTime(LocalDateTime.now());
            logEntry.setRequestMethod(req.getMethod());
            logEntry.setRequestUri(req.getRequestURI());
            logEntry.setRequestHeaders("test"); // TODO: how to get all of them?

            logEntry.setRequestBody(new String(requestWrapper.getContentAsByteArray(), UTF_8));
            logEntry.setResponseStatus(res.getStatus());
            logEntry.setResponseHeaders("test");   // TODO: how to get all of them?
            logEntry.setResponseBody("test");   // TODO: how to get body?

            try {
                logEntryRepository.save(logEntry);
            } catch (Exception e) {
                // TODO: What if LOG throws exception !? -> send email !?
            }
        }
    }
}
