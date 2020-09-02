package pt.ipl.isel.ps.iqueue.utils;

import org.springframework.beans.factory.annotation.Autowired;
import pt.ipl.isel.ps.iqueue.mapping.UserDaoModelMapper;
import pt.ipl.isel.ps.iqueue.repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

public class ErrorNotificationService {

    @Autowired
    private final EmailService emailService;

    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private final UserDaoModelMapper userDaoModelMapper;


    public ErrorNotificationService(EmailService emailService, UserRepository userRepository, UserDaoModelMapper userDaoModelMapper) {
        this.emailService = emailService;
        this.userRepository = userRepository;
        this.userDaoModelMapper = userDaoModelMapper;
    }

    public void sendErrorToAdministrators(String errorMessage) {
        getAdministratorEmails().forEach(
                email -> emailService.sendEmail(email, "IQueue - Severe Error", errorMessage)
        );
    }

    private List<String> getAdministratorEmails() {
        return userRepository
                .findAll()
                .stream()
                .map(userDao -> userDaoModelMapper.mapDaoToModel(userDao))
                .filter(user -> user.getUserProfileId() == 1)
                .map(user -> user.getEmail())
                .collect(Collectors.toList());
    }
}
