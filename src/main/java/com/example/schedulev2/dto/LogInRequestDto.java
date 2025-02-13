package com.example.schedulev2.dto;

import lombok.Getter;

@Getter
public class LogInRequestDto {

    private final String email;

    private final String password;

    public LogInRequestDto(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
