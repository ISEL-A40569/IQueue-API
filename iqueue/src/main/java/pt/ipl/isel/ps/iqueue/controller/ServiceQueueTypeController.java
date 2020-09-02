package pt.ipl.isel.ps.iqueue.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pt.ipl.isel.ps.iqueue.dao.ServiceQueueTypeDao;
import pt.ipl.isel.ps.iqueue.dao.embeddable.ServiceQueueTypeIds;
import pt.ipl.isel.ps.iqueue.mapping.ServiceQueueTypeDaoModelMapper;
import pt.ipl.isel.ps.iqueue.model.ServiceQueueType;
import pt.ipl.isel.ps.iqueue.repository.ServiceQueueTypeRepository;
import pt.ipl.isel.ps.iqueue.utils.ErrorNotificationService;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/iqueue/servicequeuetype")
public class ServiceQueueTypeController extends Controller<ServiceQueueType, ServiceQueueTypeIds, ServiceQueueTypeDao> {

    @Autowired
    private final ServiceQueueTypeRepository serviceQueueTypeRepository;

    @Autowired
    private final ServiceQueueTypeDaoModelMapper serviceQueueTypeDaoModelMapper;

    @Autowired
    private final ErrorNotificationService errorNotificationService;

    public ServiceQueueTypeController(ServiceQueueTypeRepository serviceQueueTypeRepository, ServiceQueueTypeDaoModelMapper serviceQueueTypeDaoModelMapper, ErrorNotificationService errorNotificationService) {
        super(serviceQueueTypeRepository, serviceQueueTypeDaoModelMapper, errorNotificationService);
        this.serviceQueueTypeRepository = serviceQueueTypeRepository;
        this.serviceQueueTypeDaoModelMapper = serviceQueueTypeDaoModelMapper;
        this.errorNotificationService = errorNotificationService;
    }

    @GetMapping(value = "{serviceQueueTypeId}", headers = {"Accept=application/json"})
    public ResponseEntity getById(@PathVariable int serviceQueueTypeId, @RequestParam int languageId) {
        return super.getById(new ServiceQueueTypeIds(serviceQueueTypeId, languageId));
    }

    @GetMapping(headers = {"Accept=application/json"})
    public ResponseEntity getAll(@RequestParam int languageId) {
        return super.getSome(serviceQueueTypeRepository
                .findAll()
                .stream()
                .filter(serviceQueueTypeDao -> serviceQueueTypeDao.getServiceQueueTypeIds().getLanguageId() == languageId)
                .collect(Collectors.toList())
        );
    }

    @PostMapping(headers = {"Accept=application/json", "Content-Type=application/json"})
    public ResponseEntity add(@RequestBody ServiceQueueType serviceQueueType) {
        try {
            serviceQueueTypeRepository.save(serviceQueueTypeDaoModelMapper.mapModelToDao(serviceQueueType));

            return super.add(serviceQueueType, "/api/iqueue/servicequeuetype/" + serviceQueueType
                    .getServiceQueueTypeId());

        } catch (Exception exception) {
            return ResponseEntity.status(500).build();
        }
    }

    @DeleteMapping(value = "{serviceQueueTypeId}")
    public ResponseEntity remove(@PathVariable int serviceQueueTypeId,  @RequestParam int languageId) {
        return super.remove(new ServiceQueueTypeIds(serviceQueueTypeId, languageId));
    }

    @PutMapping(value = "{serviceQueueTypeId}", headers = {"Accept=application/json", "Content-Type=application/json"})
    public ResponseEntity update(@PathVariable int serviceQueueTypeId, @RequestBody ServiceQueueType serviceQueueType) {
        serviceQueueType.setServiceQueueTypeId(serviceQueueTypeId);
        return super.update(new ServiceQueueTypeIds(serviceQueueTypeId, serviceQueueType.getLanguageId()), serviceQueueType);
    }
}
