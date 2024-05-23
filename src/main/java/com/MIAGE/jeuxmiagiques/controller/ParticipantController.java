package com.MIAGE.jeuxmiagiques.controller;

import com.MIAGE.jeuxmiagiques.model.Delegation;
import com.MIAGE.jeuxmiagiques.model.Participant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.MIAGE.jeuxmiagiques.service.ParticipantService;
import com.MIAGE.jeuxmiagiques.translatorUnits.ParticipantById;

import java.util.List;

@RestController
@RequestMapping("/api/participants")
public class ParticipantController {
    
    private Participant participantService;
    private Delegation delegationService;

    @Autowired
    public ParticipantController(Participant participantService, Delegation delegationService) {
        this.participantService = participantService;
        this.delegationService = delegationService;
    }

    @GetMapping
    public List<Participant> getAllParticipants() {
        return participantService.findAll();
    }

    @GetMapping("/{id}")
    public Participant getParticipantById(@PathVariable int id) {
        return participantService.findById(id);
    }

    @PostMapping
    public Participant createParticipant(@RequestBody ParticipantById body) {
        Participant participant = new Participant();
        Delegation delegation = delegationService.findById(body.getDelegationId());
        participant.setNom(body.getNom());
        participant.setPrenom(body.getPrenom());
        participant.setDelegation(delegation);
        return participantService.save(participant);
        
    }

    @PutMapping("/{id}")
    public Participant updateParticipant(@PathVariable int id, @RequestBody Participant participant) {
        return participantService.save(participant);
    }

    @DeleteMapping("/{id}")
    public void deleteParticipant(@PathVariable int id) {
        participantService.deleteById(id);
    }
}
