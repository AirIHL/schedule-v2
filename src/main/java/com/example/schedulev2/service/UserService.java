package com.example.schedulev2.service;

import com.example.schedulev2.dto.SignUpResponseDto;
import com.example.schedulev2.dto.UserResponseDto;
import com.example.schedulev2.entity.User;
import com.example.schedulev2.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
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

        return new UserResponseDto(findUser.getId(), findUser.getName(), findUser.getAge(), findUser.getEmail(), findUser.getPhoneNumber());
    }

    @Transactional
    public void updatePassword(Long id, String oldPassword, String newPassword) {

        User findUser = userRepository.findByIdOrElseThrow(id);

        if (!findUser.getPassword().equals(oldPassword)) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "비밀번호가 일치하지 않습니다!");
        }

        findUser.updatePassword(newPassword);

    }

    public void delete(Long id) {

        User findUser = userRepository.findByIdOrElseThrow(id);

        userRepository.delete(findUser);

    }

    public List<UserResponseDto> findAll() {

        return userRepository.findAll().stream().map(UserResponseDto::toDto).toList();
    }

    public User login(String email, String password) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("이메일 또는 비밀번호가 일치하지 않습니다."));

        if (!user.getPassword().equals(password)) {
            throw new IllegalArgumentException("이메일 또는 비밀번호가 일치하지 않습니다.");
        }

        return user;
    }
}
