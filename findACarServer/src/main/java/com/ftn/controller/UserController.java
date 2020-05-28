package com.ftn.controller;

import com.ftn.dto.RegisterDTO;
import com.ftn.service.AuthService;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Void> register(@RequestBody RegisterDTO registerDTO) {

        if (authService.register(registerDTO)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/confirm-registration/{token}")
    public ResponseEntity<Void> confirmRegistration(@PathVariable String token) {
        if (authService.verifyEmail(token)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

}
