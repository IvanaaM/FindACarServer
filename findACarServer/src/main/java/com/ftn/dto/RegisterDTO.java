package com.ftn.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterDTO {
    private String email;
    private String name;
    private String surname;
    private String password;
    private String confirmPassword;

    public RegisterDTO(String email, String name, String surname, String password) {
        this.email = email;
        this.name = name;
        this.surname = surname;
        this.password = password;
    }
}
