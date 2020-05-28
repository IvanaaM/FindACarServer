package com.ftn.service;

import com.ftn.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class NotificationService {
    private String host;
    private JavaMailSender mailSender;
    private UserService userService;

    @Autowired
    public NotificationService(@Value("${server.address.BE}") String host, JavaMailSender mailSender, UserService userService) {
        this.host = host;
        this.mailSender = mailSender;
        this.userService = userService;
    }

    private SimpleMailMessage composeEmail(String recipient, String subject, String notification) {
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(recipient);
        mail.setSubject(subject);
        mail.setText(notification);
        return mail;
    }


    @Async
    public void sendEmail(User user, String subject, String notification) {
        mailSender.send(composeEmail(user.getEmail(), subject, notification));
    }

    public void sendVerifyEmail(User user) {

        String subject = "Email verification";
        String confirmationUrl
                = host + "/user/confirm-registration/" + user.getToken();
        String emailText = "In order to be able to login, you must verify your email address. Click on this link to verify:  \n";
        try {
            sendEmail(user, subject, emailText + confirmationUrl);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
