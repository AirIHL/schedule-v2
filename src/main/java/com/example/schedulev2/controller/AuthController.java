package com.example.schedulev2.controller;

import com.example.schedulev2.dto.LogInRequestDto;
import com.example.schedulev2.entity.User;
import com.example.schedulev2.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final UserService userService;

    @PostMapping("/login")
    public ResponseEntity<String> login(
            @RequestBody LogInRequestDto requestDto,
            HttpServletRequest request
            ) {
        try {
            User user = userService.login(requestDto.getEmail(), requestDto.getPassword());

            // 세션 생성 및 사용자 정보 저장
            HttpSession session = request.getSession();
            session.setAttribute("userId", user.getId());

            return ResponseEntity.ok("로그인 성공");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
    }
}
