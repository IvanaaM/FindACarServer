package com.ftn.service;

import com.ftn.model.User;
import com.ftn.utils.firebase.NotificationParameter;
import com.ftn.utils.firebase.PushNotificationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import com.google.firebase.messaging.*;

import java.time.Duration;
import java.util.concurrent.ExecutionException;

@Service
public class NotificationService {
    private String host;
    private JavaMailSender mailSender;
    private UserService userService;

    @Autowired
    public NotificationService(JavaMailSender mailSender, UserService userService) {
        this.host = "http://localhost:8057";
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
    @Scheduled(fixedRate = 35000)
    public void sendFirebaseNotif(){
        PushNotificationRequest request = new PushNotificationRequest("Tittle", "Message body",
                "clFxY_cvFPg:APA91bE2F21nc-MqD0xsVpL8ZECJ20ke_aGvUPbkI6FDH7HShlLpSobpV_9tJBemef44HEfcqjBbSyQdsaXo3MdTbQwCaUuwI8ydySxzJh9WNqBIbzVHL0hjp6IFur0g5iHcc3AVQags", "topic");
        try {
            sendMessageToToken(request);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    public void sendMessageToToken(PushNotificationRequest request)
            throws InterruptedException, ExecutionException {
        Message message = getPreconfiguredMessageToToken(request);
        String response = sendAndGetResponse(message);
        System.out.println("Sent message to device token: " + request.getToken() + ", " + response);
    }

    private String sendAndGetResponse(Message message) throws InterruptedException, ExecutionException {
        return FirebaseMessaging.getInstance().sendAsync(message).get();
    }

    private Message getPreconfiguredMessageToToken(PushNotificationRequest request) {
        return getPreconfiguredMessageBuilder(request).setToken(request.getToken())
                .build();
    }

    private Message.Builder getPreconfiguredMessageBuilder(PushNotificationRequest request) {
        AndroidConfig androidConfig = getAndroidConfig(request.getTopic());
        ApnsConfig apnsConfig = getApnsConfig(request.getTopic());
        return Message.builder()
                .setApnsConfig(apnsConfig).setAndroidConfig(androidConfig).setNotification(
                        new Notification(request.getTitle(), request.getMessage()));
    }
    private AndroidConfig getAndroidConfig(String topic) {
        return AndroidConfig.builder()
                .setTtl(Duration.ofMinutes(2).toMillis()).setCollapseKey(topic)
                .setPriority(AndroidConfig.Priority.HIGH)
                .setNotification(AndroidNotification.builder().setSound(NotificationParameter.SOUND.getValue())
                        .setColor(NotificationParameter.COLOR.getValue()).setTag(topic).build()).build();
    }

    private ApnsConfig getApnsConfig(String topic) {
        return ApnsConfig.builder()
                .setAps(Aps.builder().setCategory(topic).setThreadId(topic).build()).build();
    }



}
