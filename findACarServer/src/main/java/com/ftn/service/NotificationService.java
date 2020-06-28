package com.ftn.service;

import com.ftn.model.Reservation;
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
import java.time.Instant;
import java.time.ZoneId;
import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

@Service
public class NotificationService {
    private String host;
    private JavaMailSender mailSender;
    private UserService userService;
    private ReservationService reservationService;

    @Autowired
    public NotificationService(JavaMailSender mailSender, UserService userService, ReservationService reservationService) {
        this.host = "http://localhost:8057";
        this.mailSender = mailSender;
        this.userService = userService;
        this.reservationService = reservationService;
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

    //@Scheduled(fixedRate = 120000)
    public void checkReservations() {
        List<Reservation> reservations = (ArrayList) reservationService.findAllUnnotified();
        reservations.forEach(res ->
        {
            if (isHoursBefore(2, res.getPickUpDate())) {
                System.out.println("nasao");
                sendFirebaseNotif(res, "Vehicle Pick Up","Please pick up the reserved vehicle: " + res.getVehicle().getName() + " within the next 2 hours.");
                res.setPickupNotificationSent(true);
                reservationService.update(res);
            }

            if (isHoursBefore(2, res.getReturnDate())) {
                System.out.println("nasao");
                sendFirebaseNotif(res, "Vehicle return","Please return the reserved vehicle: " + res.getVehicle().getName() + " within the next 2 hours.");
                res.setReturnNotificationSent(true);
                reservationService.update(res);
            }

        });
    }

    @Async
    public void sendFirebaseNotif(Reservation reservation, String title, String message) {

        PushNotificationRequest request = new PushNotificationRequest(title, message, reservation.getUser().getFcmToken(), "topic");
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


    private boolean isHoursBefore(int hours, Date date) {
        Date temp = addHours(date, hours);
        long mins = getDateDiff(new Date(), temp, TimeUnit.MINUTES);
        return mins < 10;
    }

    private Date addHours(Date date, int hours) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.HOUR, hours);
        Date retVal = cal.getTime();
        return retVal;
    }

    private long getDateDiff(Date date1, Date date2, TimeUnit timeUnit) {
        long diff = Math.abs(timeUnit.convert(date2.getTime() - date1.getTime(), TimeUnit.MILLISECONDS));
        return diff;
    }

}
