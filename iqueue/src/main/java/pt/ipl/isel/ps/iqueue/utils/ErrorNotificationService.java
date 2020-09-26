package pt.ipl.isel.ps.iqueue.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pt.ipl.isel.ps.iqueue.repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ErrorNotificationService {

    @Autowired
    private final EmailService emailService;

    @Autowired
    private final UserRepository userRepository;

    private final int ADMIN_USER_PROFILE_ID = 1;

    public ErrorNotificationService(EmailService emailService, UserRepository userRepository) {
        this.emailService = emailService;
        this.userRepository = userRepository;
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
                .filter(userDao -> userDao.getUserProfileId() == ADMIN_USER_PROFILE_ID)
                .map(userDao -> userDao.getEmail())
                .collect(Collectors.toList());
    }
}
