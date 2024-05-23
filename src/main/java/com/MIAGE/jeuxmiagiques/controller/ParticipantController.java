package com.MIAGE.jeuxmiagiques.controller;

import com.MIAGE.jeuxmiagiques.model.Delegation;
import com.MIAGE.jeuxmiagiques.model.Participant;
import com.MIAGE.jeuxmiagiques.repository.DelegationRepository;
import com.MIAGE.jeuxmiagiques.repository.ParticipantRepository;
import com.MIAGE.jeuxmiagiques.translationUnits.ParticipantById;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/participants")
public class ParticipantController {
    
    private ParticipantRepository participantRepository;
    private DelegationRepository delegationRepository;

    @Autowired
    public ParticipantController(ParticipantRepository participantRepository, DelegationRepository delegationRepository) {
        this.participantRepository = participantRepository;
        this.delegationRepository = delegationRepository;
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
    public Participant save(@RequestBody ParticipantById body) {
        Participant participant = new Participant();
        Delegation delegation = delegationRepository.findById(body.getDelegationId()).orElse(null);
        participant.setNom(body.getNom());
        participant.setPrenom(body.getPrenom());
        participant.setDelegation(delegation);
        participant.setRole("PARTICIPANT");
        return participantRepository.save(participant);
    }

    @PutMapping("/{id}")
    public Participant update(@PathVariable int id, @RequestBody ParticipantById body) {
        Participant participant = participantRepository.findById(id).orElse(null);
        Delegation delegation = delegationRepository.findById(body.getDelegationId()).orElse(null);
        if (delegation != null) participant.setDelegation(delegation);
        if (body.getNom() != null) participant.setNom(body.getNom());
        if (body.getPrenom() != null) participant.setPrenom(body.getPrenom());
        return participantRepository.save(participant);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id) {
        participantRepository.deleteById(id);
    }
}