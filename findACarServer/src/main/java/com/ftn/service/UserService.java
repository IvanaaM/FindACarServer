package com.ftn.service;

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
		
		User u = userRepository.findByEmail(userDTO.getEmail());
		
		if(u != null) {
			
			if (u.getPassword().equals(userDTO.getPassword())) {
				return true;
			} else {
				return false;
			}
			
		} else {
			return false;
		}
		
	}

}
