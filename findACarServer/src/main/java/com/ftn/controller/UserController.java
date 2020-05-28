package com.ftn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ftn.dto.LogInDTO;
import com.ftn.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@PostMapping(path = "/logIn", produces = "application/json; charset=UTF-8")
	public boolean logIn(@RequestBody LogInDTO userDTO) {
		
		boolean exists = userService.logIn(userDTO);
		
		return exists;
		
	}

}
