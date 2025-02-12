package com.example.schedulev2.service;

import com.example.schedulev2.dto.SignUpResponseDto;
import com.example.schedulev2.dto.UserResponseDto;
import com.example.schedulev2.entity.User;
import com.example.schedulev2.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public SignUpResponseDto signUp(String name, String password, Integer age, String email, String phoneNumber) {

        User user = new User(name, password, age, email, phoneNumber);

        User savedUser = userRepository.save(user);

        return new SignUpResponseDto(savedUser.getId(), savedUser.getName(), savedUser.getAge(), savedUser.getEmail(), savedUser.getPhoneNumber());
    }

    public UserResponseDto findById(Long id) {

        Optional<User> optionalUser = userRepository.findById(id);

        if (optionalUser.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "존재하지 않는 id 입니다. : " + id);
        }

        User findUser = optionalUser.get();

        return new UserResponseDto(findUser.getName(), findUser.getAge(), findUser.getEmail(), findUser.getPhoneNumber());
    }
}
