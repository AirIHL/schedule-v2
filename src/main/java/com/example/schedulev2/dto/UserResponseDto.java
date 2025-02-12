package com.example.schedulev2.dto;

import com.example.schedulev2.entity.User;
import lombok.Getter;

@Getter
public class UserResponseDto {

    private final Long id;

    private final String name;

    private final Integer age;

    private final String email;

    private final String phoneNumber;

    public UserResponseDto(Long id, String name, Integer age, String email, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public static UserResponseDto toDto(User user) {

        return new UserResponseDto(user.getId(), user.getName(), user.getAge(), user.getEmail(), user.getPhoneNumber());
    }

}
