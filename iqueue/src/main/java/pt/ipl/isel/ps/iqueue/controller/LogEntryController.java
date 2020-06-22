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

import java.time.LocalDate;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/iqueue/log")
public class LogEntryController extends Controller<LogEntry, Integer, LogEntryDao> {

    @Autowired
    private final LogEntryRepository logEntryRepository;

    @Autowired
    private final LogEntryDaoModelMapper logEntryDaoModelMapper;

    public LogEntryController(LogEntryRepository logEntryRepository, LogEntryDaoModelMapper logEntryDaoModelMapper) {
        super(logEntryRepository, logEntryDaoModelMapper);
        this.logEntryRepository = logEntryRepository;
        this.logEntryDaoModelMapper = logEntryDaoModelMapper;
    }

    @GetMapping(headers = {"Accept=application/json"})
    public ResponseEntity getAll(@RequestParam(required = false) LocalDate date) {
        if (date != null) {
            return super.getSome(logEntryRepository
                    .findAll()
                    .stream()
                    .filter(logEntryDao -> logEntryDao.getLogCreationDateTime().equals(date.atStartOfDay()))
                    .collect(Collectors.toList())
            );
        } else {
            return super.getAll();
        }
    }

    @Override
    protected ResponseEntity add(LogEntry newM) {
        throw new UnsupportedOperationException();
    }

}
