package com.ftn.service;

import com.ftn.dto.RegisterDTO;
import com.ftn.model.User;
import com.ftn.utils.PasswordUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.UUID;

@Service
public class AuthService {
    private UserService userService;
    private NotificationService notificationService;

    public AuthService(UserService userService, NotificationService notificationService) {
        this.userService = userService;
        this.notificationService = notificationService;
    }

    public boolean register(RegisterDTO registration) {
        boolean success = false;
        boolean error = false;
        if (registration.getPassword().equals(registration.getConfirmPassword())) {
            String salt = PasswordUtils.getSalt(30);
            String encodedPassword = null;
            try {
                encodedPassword = PasswordUtils.generateSecurePassword(registration.getPassword(), salt);
            } catch (Exception exc) {
                error = true;
                exc.printStackTrace();
            }

            if (!error) {
                String token = UUID.randomUUID().toString();
                User newUser = new User(registration.getName(), registration.getSurname(), registration.getEmail(), encodedPassword, LocalDate.now(), token, salt);
                success = userService.insert(newUser);
                if (success){
                    notificationService.sendVerifyEmail(newUser);
                }
            }
        }
        return success;
    }

    public boolean verifyEmail(String token) {
        boolean success = false;
        if (token == null){
            return success;
        }
        User user = userService.findByToken(token);
        if (user != null && user.getToken()!= null) {
            if (token.equals(user.getToken())) {
                user.setEmailVerified(true);
                user.setToken(null);
                userService.edit(user);
                success = userService.edit(user);
            }
        }
        return success;
    }
}
