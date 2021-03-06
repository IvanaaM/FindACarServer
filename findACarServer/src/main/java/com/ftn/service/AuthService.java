package com.ftn.service;

import com.ftn.dto.ChangePasswordDTO;
import com.ftn.dto.EditProfileDTO;
import com.ftn.dto.RegisterDTO;
import com.ftn.model.User;
import com.ftn.repository.UserRepository;
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
		User found = userService.findByEmail(registration.getEmail());
		if (found != null) {
			return false;
		}
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
				User newUser = new User(registration.getName(), registration.getSurname(), registration.getEmail(),
						encodedPassword, LocalDate.now(), token, salt);
				success = userService.insert(newUser);
				if (success) {
					notificationService.sendVerifyEmail(newUser);
				}
			}
		}
		return success;
	}

	public boolean verifyEmail(String token) {
		boolean success = false;
		if (token == null) {
			return success;
		}
		User user = userService.findByToken(token);
		if (user != null && user.getToken() != null) {
			if (token.equals(user.getToken())) {
				user.setEmailVerified(true);
				user.setToken(null);
				userService.edit(user);
				success = userService.edit(user);
			}
		}
		return success;
	}

	public boolean changePassword(String email, ChangePasswordDTO changePasswordDTO) {
		boolean success = false;
		boolean error = false;
		User user = userService.findByEmail(email + ".com");
		if (user != null) {
			if (PasswordUtils.verifyUserPassword(changePasswordDTO.getOldPassword(), user.getPassword(),
					user.getSalt())) {
				if (changePasswordDTO.getConfirmPassword().equals(changePasswordDTO.getNewPassword())) {
					String salt1 = PasswordUtils.getSalt(30);
					String encodedPassword = null;
					try {
						encodedPassword = PasswordUtils.generateSecurePassword(changePasswordDTO.getNewPassword(),
								salt1);
					} catch (Exception exc) {
						error = true;
						exc.printStackTrace();
					}
					user.setPassword(encodedPassword);
					user.setSalt(salt1);
					success = userService.edit(user);

				}

			}
		}
		return success;

	}

	public boolean editProfile(String email, EditProfileDTO editProfileDTO) {
		boolean success = false;
		User user = userService.findByEmail(email + ".com");
		if (user != null) {
			user.setFirstName(editProfileDTO.getFirstName());
			user.setLastName(editProfileDTO.getLastName());
			success = userService.edit(user);
		}
		return success;
	}

}
