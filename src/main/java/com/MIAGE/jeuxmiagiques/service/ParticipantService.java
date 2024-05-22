package com.MIAGE.jeuxmiagiques.service;

import com.MIAGE.jeuxmiagiques.model.Participant;
import com.MIAGE.jeuxmiagiques.repository.ParticipantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParticipantService {
    @Autowired
    private ParticipantRepository participantRepository;

    public List<Participant> findAll() {
        return participantRepository.findAll();
    }

    public Participant findById(int id) {
        return participantRepository.findById(id).orElse(null);
    }

    public Participant save(Participant participant) {
        return participantRepository.save(participant);
    }

    public void deleteById(int id) {
        participantRepository.deleteById(id);
    }
}
