package pt.ipl.isel.ps.iqueue.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private final EmailConfiguration emailConfiguration;

    private final JavaMailSenderImpl mailSender;

    public EmailService(EmailConfiguration emailConfiguration) {
        this.emailConfiguration = emailConfiguration;
        this.mailSender =  new JavaMailSenderImpl();
        mailSender.setHost(emailConfiguration.getHost());
        mailSender.setPort(emailConfiguration.getPort());
        mailSender.setUsername(emailConfiguration.getUsername());
        mailSender.setPassword(emailConfiguration.getPassword());
    }

    public void sendEmail(String emailAddress, String subject, String message) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom("donotreply@iqueue.com");
        mailMessage.setTo(emailAddress);
        mailMessage.setSubject(subject);
        mailMessage.setText(message);

        mailSender.send(mailMessage);
    }
}
