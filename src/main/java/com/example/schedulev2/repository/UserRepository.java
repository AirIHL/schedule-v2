package com.example.schedulev2.repository;

import com.example.schedulev2.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
