package com.MIAGE.jeuxmiagiques.repository;

import com.MIAGE.jeuxmiagiques.model.Participant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParticipantRepository extends JpaRepository<Participant, Integer> {
}
