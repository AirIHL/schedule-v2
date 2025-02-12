package com.example.schedulev2.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
@Table(name = "users")
public class User extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 30)
    private String name;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private Integer age;

    @Column(nullable = false, unique = true, length = 90)
    private String email;

    @Column(length = 20)
    private String phoneNumber;

    public User() {
    }

    public User(String name, String password, Integer age, String email, String phoneNumber) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.password = password;
    }

    public void updatePassword(String password) {
        this.password = password;
    }

}
