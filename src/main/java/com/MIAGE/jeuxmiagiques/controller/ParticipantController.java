package com.MIAGE.jeuxmiagiques.controller;

import com.MIAGE.jeuxmiagiques.model.Delegation;
import com.MIAGE.jeuxmiagiques.model.Participant;
import com.MIAGE.jeuxmiagiques.model.User;
import com.MIAGE.jeuxmiagiques.repository.DelegationRepository;
import com.MIAGE.jeuxmiagiques.repository.ParticipantRepository;
import com.MIAGE.jeuxmiagiques.repository.UserRepository;
import com.MIAGE.jeuxmiagiques.translationUnits.ParticipantById;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/participants")
public class ParticipantController {
    
    private ParticipantRepository participantRepository;
    private DelegationRepository delegationRepository;
    private UserRepository userRepository;

    private PasswordEncoder passwordEncoder;

    @Autowired
    public ParticipantController(ParticipantRepository participantRepository, DelegationRepository delegationRepository, UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.participantRepository = participantRepository;
        this.delegationRepository = delegationRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }
    @GetMapping
    public List<Participant> findAll() {
        return participantRepository.findAll();
    }

    @GetMapping("/{id}")
    public Participant findById(@PathVariable int id) {
        return participantRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Participant save(@RequestBody ParticipantById user) {
        if (userRepository.findByEmail(user.getEmail()) != null) {
            throw new RuntimeException("User already exists");
        }
        switch (user.getDelegationId()) {
            case 0:
                throw new RuntimeException("Delegation id is required");
            case -1:
                throw new RuntimeException("Delegation id is invalid");
            default:
                break;
        }
        System.out.println(user.getDelegationId());
        Participant participant = new Participant();
        participant.setNom(user.getNom());
        participant.setPrenom(user.getPrenom());
        participant.setEmail(user.getEmail());
        participant.setPassword(passwordEncoder.encode(user.getPassword()));
        Delegation delegation = delegationRepository.findById(user.getDelegationId()).orElse(null);
        participant.setDelegation(delegation);
        participant.setUserRole("participant");
        userRepository.save(participant);
        return participantRepository.save(participant);
    }

    @PutMapping("/{id}")
    public Participant update(@PathVariable int id, @RequestBody ParticipantById body) {
        Participant participant = participantRepository.findById(id).orElse(null);
        // If the delegation id in not provided in the request body, we keep the current delegation
        if (body.getDelegationId() == 0) body.setDelegationId(participant.getDelegation().getId());
        else if (body.getDelegationId() < 0) body.setDelegationId(0);
        else {
            Delegation delegation = delegationRepository.findById(body.getDelegationId()).orElse(null);
            participant.setDelegation(delegation);
        }
        return participantRepository.save(participant);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id) {
        participantRepository.deleteById(id);
    }
}