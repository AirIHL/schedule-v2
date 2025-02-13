package com.example.schedulev2.repository;

import com.example.schedulev2.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findUserByName(String name);

    Optional<User> findByEmail(String email);

    default User findUserByNameOrElseThrow(String name) {
        return findUserByName(name).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exist userName = " + name));
    }

    default User findByIdOrElseThrow(Long id) {
        return findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "존재하지 않는 ID 입니다. : " + id));
    }
}
