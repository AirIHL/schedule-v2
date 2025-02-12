package com.example.schedulev2.dto;

import lombok.Getter;

@Getter
public class UserResponseDto {

    private final String name;

    private final Integer age;

    private final String email;

    private final String phoneNumber;

    public UserResponseDto(String name, Integer age, String email, String phoneNumber) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
}
