package com.MIAGE.jeuxmiagiques.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.MIAGE.jeuxmiagiques.model.Organisateur;
import com.MIAGE.jeuxmiagiques.model.Participant;
import com.MIAGE.jeuxmiagiques.model.Spectateur;
import com.MIAGE.jeuxmiagiques.model.User;

import com.MIAGE.jeuxmiagiques.repository.OrganisateurRepository;
import com.MIAGE.jeuxmiagiques.repository.ParticipantRepository;
import com.MIAGE.jeuxmiagiques.repository.SpectateurRepository;
import com.MIAGE.jeuxmiagiques.repository.UserRepository;

@RestController
@RequestMapping("/register")
public class RegistrationController {

    private UserRepository userRepository;
    private SpectateurRepository spectateurRepository;
    private OrganisateurRepository organisateurRepository;
    private ParticipantRepository participantRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public RegistrationController(UserRepository userRepository, SpectateurRepository spectateurRepository, OrganisateurRepository organisateurRepository, ParticipantRepository participantRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.spectateurRepository = spectateurRepository;
        this.organisateurRepository = organisateurRepository;
        this.participantRepository = participantRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/spectateur")
    // It works
    public Spectateur registerSpectateur(@RequestBody User user) {
        if (userRepository.findByEmail(user.getEmail()) != null) {
            throw new RuntimeException("User already exists");
        }
        Spectateur spectateur = new Spectateur();
        spectateur.setPassword(passwordEncoder.encode(user.getPassword()));
        spectateur.setUserRole("spectateur");
        spectateur.setNom(user.getNom());
        spectateur.setPrenom(user.getPrenom());
        spectateur.setEmail(user.getEmail());
        spectateur.setUserRole(user.getUserRole());
        
        return spectateurRepository.save(spectateur);
    }

    @PostMapping("/organisateur")
    public Organisateur registerOrganisateur(@RequestBody User user) {
        if (userRepository.findByEmail(user.getEmail()) != null) {
            throw new RuntimeException("User already exists");
        }

        Organisateur organisateur = new Organisateur();
        organisateur.setPassword(passwordEncoder.encode(user.getPassword()));
        organisateur.setUserRole("organisateur");
        organisateur.setNom(user.getNom());
        organisateur.setPrenom(user.getPrenom());
        organisateur.setEmail(user.getEmail());
        organisateur.setUserRole(user.getUserRole());
        
        return organisateurRepository.save(organisateur);
    }

    @PostMapping("/participant")
    public Participant registerParticipant(@RequestBody User user) {
        if (userRepository.findByEmail(user.getEmail()) != null) {
            throw new RuntimeException("User already exists");
        }

        Participant participant = new Participant();
        participant.setPassword(passwordEncoder.encode(user.getPassword()));
        participant.setUserRole("participant");
        participant.setNom(user.getNom());
        participant.setPrenom(user.getPrenom());
        participant.setEmail(user.getEmail());
        participant.setUserRole(user.getUserRole());
        
        return participantRepository.save(participant);
    }
}
