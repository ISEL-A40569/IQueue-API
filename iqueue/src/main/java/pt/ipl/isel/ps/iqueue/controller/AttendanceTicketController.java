package pt.ipl.isel.ps.iqueue.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pt.ipl.isel.ps.iqueue.dao.AttendanceTicketDao;
import pt.ipl.isel.ps.iqueue.mapping.AttendanceTicketDaoModelMapper;
import pt.ipl.isel.ps.iqueue.model.AttendanceTicket;
import pt.ipl.isel.ps.iqueue.repository.AttendanceTicketRepository;

@RestController
@RequestMapping("/api/iqueue/attendance")
public class AttendanceTicketController extends Controller<AttendanceTicket, Integer, AttendanceTicketDao> {

    @Autowired
    private final AttendanceTicketRepository attendanceTicketRepository;

    @Autowired
    private final AttendanceTicketDaoModelMapper attendanceTicketDaoModelMapper;

    public AttendanceTicketController(AttendanceTicketRepository attendanceTicketRepository, AttendanceTicketDaoModelMapper attendanceTicketDaoModelMapper) {
        super(attendanceTicketRepository, attendanceTicketDaoModelMapper);
        this.attendanceTicketRepository = attendanceTicketRepository;
        this.attendanceTicketDaoModelMapper = attendanceTicketDaoModelMapper;
    }

    @GetMapping(value = "{attendanceId}/ticket", headers = {"Accept=application/json"})
    public ResponseEntity getById(@PathVariable int attendanceId) {
        return super.getById(attendanceId);
    }

    @Override
    protected ResponseEntity add(AttendanceTicket newM) {
        throw new UnsupportedOperationException();
    }

    @DeleteMapping(value = "{attendanceId}/ticket")
    public ResponseEntity remove(@PathVariable int attendanceId) {
        return super.remove(attendanceId);
    }
}
