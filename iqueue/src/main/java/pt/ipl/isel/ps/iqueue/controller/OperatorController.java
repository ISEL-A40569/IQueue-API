package pt.ipl.isel.ps.iqueue.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pt.ipl.isel.ps.iqueue.dao.AttendanceDao;
import pt.ipl.isel.ps.iqueue.dao.DeskDao;
import pt.ipl.isel.ps.iqueue.dao.OperatorDao;
import pt.ipl.isel.ps.iqueue.dao.ServiceQueueDao;
import pt.ipl.isel.ps.iqueue.mapping.OperatorDaoModelMapper;
import pt.ipl.isel.ps.iqueue.model.Operator;
import pt.ipl.isel.ps.iqueue.repository.*;

import javax.transaction.Transactional;
import java.util.List;

//@CrossOrigin(origins = "https://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/api/iqueue/operator")
public class OperatorController extends Controller<Operator, Integer, OperatorDao> {

    @Autowired
    private final OperatorRepository operatorRepository;

    @Autowired
    private final OperatorBeaconRepository operatorBeaconRepository;

    @Autowired
    private final OperatorUserRepository operatorUserRepository;

    @Autowired
    private final ServiceQueueRepository serviceQueueRepository;

    @Autowired
    private final AttendanceRepository attendanceRepository;

    @Autowired
    private final AttendanceClassificationRepository attendanceClassificationRepository;

    @Autowired
    private final AttendanceTicketRepository attendanceTicketRepository;

    @Autowired
    private final DeskRepository deskRepository;

    @Autowired
    private final DeskUserRepository deskUserRepository;

    @Autowired
    private final OperatorDaoModelMapper operatorDaoModelMapper;


    public OperatorController(OperatorRepository operatorRepository, OperatorBeaconRepository operatorBeaconRepository, OperatorUserRepository operatorUserRepository, ServiceQueueRepository serviceQueueRepository, AttendanceRepository attendanceRepository, AttendanceClassificationRepository attendanceClassificationRepository, AttendanceTicketRepository attendanceTicketRepository, DeskRepository deskRepository, DeskUserRepository deskUserRepository, OperatorDaoModelMapper operatorDaoModelMapper) {
        super(operatorRepository, operatorDaoModelMapper);
        this.operatorRepository = operatorRepository;
        this.operatorBeaconRepository = operatorBeaconRepository;
        this.operatorUserRepository = operatorUserRepository;
        this.serviceQueueRepository = serviceQueueRepository;
        this.attendanceRepository = attendanceRepository;
        this.attendanceClassificationRepository = attendanceClassificationRepository;
        this.attendanceTicketRepository = attendanceTicketRepository;
        this.deskRepository = deskRepository;
        this.deskUserRepository = deskUserRepository;
        this.operatorDaoModelMapper = operatorDaoModelMapper;
    }

    @GetMapping(value = "{operatorId}", headers = {"Accept=application/json"})
    public ResponseEntity getById(@PathVariable int operatorId) {
        return super.getById(operatorId);
    }

    @GetMapping(headers = {"Accept=application/json"})
    public ResponseEntity getAll() {
        return super.getAll();
    }

    @PostMapping(headers = {"Accept=application/json", "Content-Type=application/json"})
    public ResponseEntity add(@RequestBody Operator operator) {
        try {
            Operator createdOperator = operatorDaoModelMapper.mapDaoToModel(operatorRepository
                    .save(operatorDaoModelMapper.mapModelToDao(operator)));

            return super.add(createdOperator, "/api/iqueue/operator/" + createdOperator.getOperatorId());
        } catch (Exception exception) {
            return ResponseEntity.status(500).build();
        }
    }

    @DeleteMapping(value = "{operatorId}")
    @Transactional
    public ResponseEntity remove(@PathVariable int operatorId) {
        try {
            operatorBeaconRepository.deleteByOperatorBeaconIdsOperatorId(operatorId);
            operatorUserRepository.deleteByOperatorUserIdsOperatorId(operatorId);

            List<ServiceQueueDao> serviceQueues = serviceQueueRepository.findByOperatorId(operatorId);


            serviceQueues.forEach(serviceQueueDao -> {
                List<AttendanceDao> attendances = attendanceRepository.findByServiceQueueId(serviceQueueDao.getServiceQueueId());

                attendances.forEach(attendanceDao -> {
                    attendanceTicketRepository.deleteByAttendanceId(attendanceDao.getAttendanceId());
                    attendanceClassificationRepository.deleteByAttendanceId(attendanceDao.getAttendanceId());
                });

                attendanceRepository.deleteByServiceQueueId(serviceQueueDao.getServiceQueueId());

                List<DeskDao> desks = deskRepository.findByServiceQueueId(serviceQueueDao.getServiceQueueId());

                desks.forEach(deskDao -> deskUserRepository.deleteByDeskUserIdsDeskId(deskDao.getDeskId()));

                deskRepository.deleteByServiceQueueId(serviceQueueDao.getServiceQueueId());

                serviceQueueRepository.delete(serviceQueueDao);
            });
        } catch (Exception exception) {
            return ResponseEntity.status(500).build();
        }

        return super.remove(operatorId);
    }

    @PutMapping(value = "{operatorId}", headers = {"Accept=application/json", "Content-Type=application/json"})
    public ResponseEntity update(@PathVariable int operatorId, @RequestBody Operator operator) {
        operator.setOperatorId(operatorId);
        return super.update(operatorId, operator);
    }
}
