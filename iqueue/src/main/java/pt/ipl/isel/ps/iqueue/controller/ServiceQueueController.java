package pt.ipl.isel.ps.iqueue.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pt.ipl.isel.ps.iqueue.dao.AttendanceDao;
import pt.ipl.isel.ps.iqueue.dao.DeskDao;
import pt.ipl.isel.ps.iqueue.dao.ServiceQueueDao;
import pt.ipl.isel.ps.iqueue.mapping.ServiceQueueDaoModelMapper;
import pt.ipl.isel.ps.iqueue.model.ServiceQueue;
import pt.ipl.isel.ps.iqueue.repository.*;
import pt.ipl.isel.ps.iqueue.utils.ErrorNotificationService;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/iqueue/servicequeue")
public class ServiceQueueController extends Controller<ServiceQueue, Integer, ServiceQueueDao> {

    @Autowired
    private final ServiceQueueRepository serviceQueueRepository;

    @Autowired
    private final ServiceQueueWaitingCountRepository serviceQueueWaitingCountRepository;

    @Autowired
    private final ServiceQueueCurrentAttendanceRepository serviceQueueCurrentAttendanceRepository;

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
    private final ServiceQueueDaoModelMapper serviceQueueDaoModelMapper;

    @Autowired
    private final ErrorNotificationService errorNotificationService;

    public ServiceQueueController(ServiceQueueRepository serviceQueueRepository, ServiceQueueWaitingCountRepository serviceQueueWaitingCountRepository, ServiceQueueCurrentAttendanceRepository serviceQueueCurrentAttendanceRepository, AttendanceRepository attendanceRepository, AttendanceClassificationRepository attendanceClassificationRepository, AttendanceTicketRepository attendanceTicketRepository, DeskRepository deskRepository, DeskUserRepository deskUserRepository, ServiceQueueDaoModelMapper serviceQueueDaoModelMapper, ErrorNotificationService errorNotificationService) {
        super(serviceQueueRepository, serviceQueueDaoModelMapper, errorNotificationService);
        this.serviceQueueRepository = serviceQueueRepository;
        this.serviceQueueWaitingCountRepository = serviceQueueWaitingCountRepository;
        this.serviceQueueCurrentAttendanceRepository = serviceQueueCurrentAttendanceRepository;
        this.attendanceRepository = attendanceRepository;
        this.attendanceClassificationRepository = attendanceClassificationRepository;
        this.attendanceTicketRepository = attendanceTicketRepository;
        this.deskRepository = deskRepository;
        this.deskUserRepository = deskUserRepository;
        this.serviceQueueDaoModelMapper = serviceQueueDaoModelMapper;
        this.errorNotificationService = errorNotificationService;
    }

    @GetMapping(headers = {"Accept=application/json"})
    public ResponseEntity getOperatorServiceQueues(@RequestParam int operatorId) {
        return super.getSome(serviceQueueRepository
                .findAll()
                .stream()
                .filter(serviceQueueDao -> serviceQueueDao.getOperatorId() == operatorId)
                .collect(Collectors.toList())
        );
    }

    @GetMapping(value = "{serviceQueueId}", headers = {"Accept=application/json"})
    public ResponseEntity getById(@PathVariable Integer serviceQueueId) {
        return super.getById(serviceQueueId);
    }

    @GetMapping(value = "waitingcount/{deskId}", headers = {"Accept=application/json"})
    public ResponseEntity getServiceQueueWaitingCount(@PathVariable int deskId) {
        try {
            return ResponseEntity.ok(serviceQueueWaitingCountRepository.get(deskId).get());
        } catch (Exception exception) {
            return ResponseEntity.status(500).build();
        }
    }

    @GetMapping(value = "{serviceQueueId}/currentattendance", headers = {"Accept=application/json"})
    public ResponseEntity getServiceQueueCurrentAttendanceTicketNumber(@PathVariable int serviceQueueId) {
        try {
            return ResponseEntity.ok(serviceQueueCurrentAttendanceRepository.get(serviceQueueId).get());
        } catch (Exception exception) {
            return ResponseEntity.status(500).build();
        }
    }

    @PostMapping(headers = {"Accept=application/json", "Content-Type=application/json"})
    public ResponseEntity add(@RequestBody ServiceQueue serviceQueue) {
        try {
            ServiceQueue createdServiceQueue = serviceQueueDaoModelMapper.mapDaoToModel(serviceQueueRepository
                    .save(serviceQueueDaoModelMapper.mapModelToDao(serviceQueue)));

            return super.add(createdServiceQueue, "/api/iqueue/servicequeue/" + createdServiceQueue.getServiceQueueId());
        } catch (Exception exception) {
            return ResponseEntity.status(500).build();
        }
    }

    @DeleteMapping("{serviceQueueId}")
    @Transactional
    public ResponseEntity remove(@PathVariable int serviceQueueId) {
        try {
            List<AttendanceDao> attendances = attendanceRepository.findByServiceQueueId(serviceQueueId);
            attendances.forEach(attendanceDao -> {
                attendanceTicketRepository.deleteByAttendanceId(attendanceDao.getAttendanceId());
                attendanceClassificationRepository.deleteByAttendanceId(attendanceDao.getAttendanceId());
            });

            attendanceRepository.deleteByServiceQueueId(serviceQueueId);

            List<DeskDao> desks = deskRepository.findByServiceQueueId(serviceQueueId);

            desks.forEach(deskDao -> deskUserRepository.deleteByDeskUserIdsDeskId(deskDao.getDeskId()));

            deskRepository.deleteByServiceQueueId(serviceQueueId);

            return super.remove(serviceQueueId);
        } catch (Exception exception) {
            return ResponseEntity.status(500).build();
        }
    }

    @PutMapping(value = "{serviceQueueId}", headers = {"Accept=application/json", "Content-Type=application/json"})
    public ResponseEntity update(@PathVariable int serviceQueueId, @RequestBody ServiceQueue serviceQueue) {
        serviceQueue.setServiceQueueId(serviceQueueId);
        return super.update(serviceQueueId, serviceQueue);
    }
}
