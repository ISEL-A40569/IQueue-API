package pt.ipl.isel.ps.iqueue.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pt.ipl.isel.ps.iqueue.model.ServiceQueueStatistic;
import pt.ipl.isel.ps.iqueue.repository.ServiceQueueStatisticRepository;
import pt.ipl.isel.ps.iqueue.utils.ErrorNotificationService;

import java.util.Optional;

@RestController
@RequestMapping("/api/iqueue/servicequeue/{serviceQueueId}/statistics")
public class ServiceQueueStatisticsController {

    @Autowired
    private final ServiceQueueStatisticRepository serviceQueueStatisticRepository;

    @Autowired
    private final ErrorNotificationService errorNotificationService;

    public ServiceQueueStatisticsController(ServiceQueueStatisticRepository serviceQueueStatisticRepository, ErrorNotificationService errorNotificationService) {
        this.serviceQueueStatisticRepository = serviceQueueStatisticRepository;
        this.errorNotificationService = errorNotificationService;
    }

    @GetMapping(headers = {"Accept=application/json"})
    public ResponseEntity getStatistics(@PathVariable int serviceQueueId) {
        Optional<ServiceQueueStatistic> serviceQueueStatisticOptional = serviceQueueStatisticRepository.get(serviceQueueId);

        try {
            if (serviceQueueStatisticOptional.isPresent()) {
                return ResponseEntity.ok(serviceQueueStatisticOptional.get());
            } else {
                return ResponseEntity.status(404).build();
            }
        } catch (Exception exception) {
            errorNotificationService.sendErrorToAdministrators(exception.getMessage());
            return ResponseEntity.status(500).build();
        }
    }

}
