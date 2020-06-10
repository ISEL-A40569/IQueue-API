package pt.ipl.isel.ps.iqueue.mapping;

import org.springframework.stereotype.Component;
import pt.ipl.isel.ps.iqueue.dao.LogEntryDao;
import pt.ipl.isel.ps.iqueue.model.LogEntry;

@Component
public class LogEntryDaoModelMapper implements DaoModelMapper<LogEntryDao, LogEntry> {
    @Override
    public LogEntry mapDaoToModel(LogEntryDao dao) {
        return new LogEntry(dao.getLogId(), dao.getLogCreationDateTime(),
                dao.getRequestMethod(), dao.getRequestUri(),
                dao.getRequestHeaders(), dao.getRequestBody(),
                dao.getResponseStatus(), dao.getResponseHeaders(),
                dao.getResponseBody());
    }

    @Override
    public LogEntryDao mapModelToDao(LogEntry model) {
        return new LogEntryDao(model.getLogId(), model.getLogCreationDateTime(),
                model.getRequestMethod(), model.getRequestUri(),
                model.getRequestHeaders(), model.getRequestBody(),
                model.getResponseStatus(), model.getResponseHeaders(),
                model.getResponseBody());
    }
}
