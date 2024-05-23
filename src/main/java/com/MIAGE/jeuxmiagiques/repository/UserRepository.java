package com.MIAGE.jeuxmiagiques.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.MIAGE.jeuxmiagiques.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
