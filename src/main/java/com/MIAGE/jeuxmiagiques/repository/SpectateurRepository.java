package com.MIAGE.jeuxmiagiques.repository;

import com.MIAGE.jeuxmiagiques.model.Spectateur;
import org.springframework.data.jpa.repository.JpaRepository;

import com.MIAGE.jeuxmiagiques.model.User;

public interface SpectateurRepository extends JpaRepository<Spectateur, Integer> {
}
