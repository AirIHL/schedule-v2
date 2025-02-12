package com.example.schedulev2.dto;

import lombok.Getter;

@Getter
public class SignUpRequestDto {

    private final String name;

    private final String password;

    private final Integer age;

    private final String email;

    private final String phoneNumber;

    public SignUpRequestDto(String name, String password, Integer age, String email, String phoneNumber) {
        this.name = name;
        this.password = password;
        this.age = age;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
}
