package pt.ipl.isel.ps.iqueue.mapping;

import pt.ipl.isel.ps.iqueue.dao.LogEntryDao;
import pt.ipl.isel.ps.iqueue.model.LogEntry;

public class LogEntryDaoModelMapper implements DaoModelMapper<LogEntryDao, LogEntry> {
    @Override
    public LogEntry mapDtoToModel(LogEntryDao dao) {
        return new LogEntry(dao.getLogId(), dao.getLogCreationDateTime(),
                dao.getRequestMethod(), dao.getRequestUri(),
                dao.getRequestHeaders(), dao.getRequestBody(),
                dao.getResponseStatus(), dao.getResponseHeaders(),
                dao.getResponseBody());
    }

    @Override
    public LogEntryDao mapModelToDto(LogEntry model) {
        return new LogEntryDao(model.getLogId(), model.getLogCreationDateTime(),
                model.getRequestMethod(), model.getRequestUri(),
                model.getRequestHeaders(), model.getRequestBody(),
                model.getResponseStatus(), model.getResponseHeaders(),
                model.getResponseBody());
    }
}
