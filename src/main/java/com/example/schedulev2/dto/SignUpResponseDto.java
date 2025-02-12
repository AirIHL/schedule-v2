package com.example.schedulev2.dto;

import lombok.Getter;

@Getter
public class SignUpResponseDto {

    private final Long id;

    private final String name;

    private final Integer age;

    private final String email;

    private final String phoneNumber;

    public SignUpResponseDto(Long id, String name, Integer age, String email, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
}
