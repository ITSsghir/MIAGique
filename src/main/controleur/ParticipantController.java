package com.MIAGE.jeuxmiagiques.controller;

import com.MIAGE.jeuxmiagiques.model.Participant;
import com.MIAGE.jeuxmiagiques.service.ParticipantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/participants")
public class ParticipantController {
    @Autowired
    private ParticipantService participantService;

    @GetMapping
    public List<Participant> getAllParticipants() {
        return participantService.findAll();
    }

    @GetMapping("/{id}")
    public Participant getParticipantById(@PathVariable Long id) {
        return participantService.findById(id);
    }

    @PostMapping
    public Participant createParticipant(@RequestBody Participant participant) {
        return participantService.save(participant);
    }

    @PutMapping("/{id}")
    public Participant updateParticipant(@PathVariable Long id, @RequestBody Participant participant) {
        participant.setId(id);
        return participantService.save(participant);
    }

    @DeleteMapping("/{id}")
    public void deleteParticipant(@PathVariable Long id) {
        participantService.deleteById(id);
    }
}
