package pt.ipl.isel.ps.iqueue.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pt.ipl.isel.ps.iqueue.dao.LogEntryDao;
import pt.ipl.isel.ps.iqueue.mapping.LogEntryDaoModelMapper;
import pt.ipl.isel.ps.iqueue.model.LogEntry;
import pt.ipl.isel.ps.iqueue.repository.LogEntryRepository;
import pt.ipl.isel.ps.iqueue.utils.ErrorNotificationService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/iqueue/log")
public class LogEntryController extends Controller<LogEntry, Integer, LogEntryDao> {

    @Autowired
    private final LogEntryRepository logEntryRepository;

    @Autowired
    private final LogEntryDaoModelMapper logEntryDaoModelMapper;

    @Autowired
    private final ErrorNotificationService errorNotificationService;

    public LogEntryController(LogEntryRepository logEntryRepository, LogEntryDaoModelMapper logEntryDaoModelMapper, ErrorNotificationService errorNotificationService) {
        super(logEntryRepository, logEntryDaoModelMapper, errorNotificationService);
        this.logEntryRepository = logEntryRepository;
        this.logEntryDaoModelMapper = logEntryDaoModelMapper;
        this.errorNotificationService = errorNotificationService;
    }

    @GetMapping(headers = {"Accept=application/json"})
    public ResponseEntity getAll(@RequestParam String date) {
        LocalDateTime localDateTime = LocalDate.parse(date).atStartOfDay();
        return super.getSome(logEntryRepository
                .findAll()
                .stream()
                .filter(logEntryDao ->
                        logEntryDao.getLogCreationDateTime()
                                .isAfter(localDateTime) &&
                                logEntryDao.getLogCreationDateTime()
                                        .isBefore(localDateTime.plusDays(1))
                )
                .collect(Collectors.toList()));
    }

    @Override
    protected ResponseEntity add(LogEntry newM) {
        throw new UnsupportedOperationException();
    }

}
