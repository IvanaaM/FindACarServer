package com.ftn.service;

import com.ftn.utils.PasswordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftn.dto.LogInDTO;
import com.ftn.model.User;
import com.ftn.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public boolean logIn(LogInDTO userDTO) {
        boolean success = false;
        User u = userRepository.findByEmail(userDTO.getEmail());

        if (u != null) {
            if (PasswordUtils.verifyUserPassword(userDTO.getPassword(), u.getPassword(), u.getSalt())) {
                success = true;
            }
        }
        return success;
    }

    public boolean insert(User user) {
        boolean success = false;
        if (userRepository.save(user) != null) {
            success = true;
        }
        return success;
    }

    public boolean edit(User user){
		boolean success = false;
    	if (findById(user.getId()) != null){
    		User edited = userRepository.save(user);
    		if (edited != null){
    			success = true;
			}
		}
		return success;
	}
    public User findById(Long userId) {
        User user = null;
        if (userRepository.findById(userId).isPresent()){
            user = userRepository.findById(userId).get();
        }
        return user;
    }

    public User findByToken(String token) {
        return userRepository.findByToken(token);
    }


}
