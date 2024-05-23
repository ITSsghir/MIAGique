package com.MIAGE.jeuxmiagiques.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.MIAGE.jeuxmiagiques.model.Organisateur;
import com.MIAGE.jeuxmiagiques.model.Participant;
import com.MIAGE.jeuxmiagiques.model.Spectateur;
import com.MIAGE.jeuxmiagiques.model.User;
import com.MIAGE.jeuxmiagiques.repository.OrganisateurRepository;
import com.MIAGE.jeuxmiagiques.repository.ParticipantRepository;
import com.MIAGE.jeuxmiagiques.repository.SpectateurRepository;
import com.MIAGE.jeuxmiagiques.repository.UserRepository;

@Controller
@RequestMapping("/register")
public class RegistrationController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SpectateurRepository spectateurRepository;

    @Autowired
    private OrganisateurRepository organisateurRepository;

    @Autowired
    private ParticipantRepository participantRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping
    public String showRegistrationForm() {
        return "register";
    }

    @PostMapping("/register/spectateur")
    public String registerSpectateur(User user) {
        if (userRepository.findByEmail(user.getEmail()) != null) {
            return "redirect:/register?error";
        }

        Spectateur spectateur = new Spectateur();
        spectateur.setEmail(user.getEmail());
        spectateur.setPassword(passwordEncoder.encode(user.getPassword()));
        spectateur.setRole("SPECTATEUR");
        spectateurRepository.save(spectateur);

        return "redirect:/login";
    }

    @PostMapping("/register/organisateur")
    public String registerOrganisateur(User user) {
        if (userRepository.findByEmail(user.getEmail()) != null) {
            return "redirect:/register?error";
        }

        Organisateur organisateur = new Organisateur();
        organisateur.setEmail(user.getEmail());
        organisateur.setPassword(passwordEncoder.encode(user.getPassword()));
        organisateur.setRole("ORGANISATEUR");
        organisateurRepository.save(organisateur);

        return "redirect:/login";
    }

    @PostMapping("/register/participant")
    public String registerParticipant(User user) {
        if (userRepository.findByEmail(user.getEmail()) != null) {
            return "redirect:/register?error";
        }

        Participant participant = new Participant();
        participant.setEmail(user.getEmail());
        participant.setPassword(passwordEncoder.encode(user.getPassword()));
        participant.setRole("PARTICIPANT");
        participantRepository.save(participant);

        return "redirect:/login";
    }
}
