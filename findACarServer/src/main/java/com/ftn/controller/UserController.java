package com.ftn.controller;

import com.ftn.dto.RegisterDTO;
import com.ftn.service.AuthService;
import org.springframework.web.bind.annotation.*;
import com.ftn.dto.LogInDTO;
import com.ftn.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

    UserService userService;
    AuthService authService;

    public UserController(UserService userService, AuthService authService) {
        this.userService = userService;
        this.authService = authService;
    }

    @PostMapping(path = "/logIn", produces = "application/json; charset=UTF-8")
    public boolean logIn(@RequestBody LogInDTO userDTO) {

        boolean exists = userService.logIn(userDTO);
        return exists;

    }

    @PostMapping("/auth/register")
    public boolean register(@RequestBody RegisterDTO registerDTO) {
        return authService.register(registerDTO);
    }

    @GetMapping("/confirm-registration/{token}")
    public boolean confirmRegistration(@PathVariable String token) {
        return authService.verifyEmail(token);
    }

}
