package com.MIAGE.jeuxmiagiques.controller;

import com.MIAGE.jeuxmiagiques.model.Organisateur;
import com.MIAGE.jeuxmiagiques.repository.UserRepository;
import com.MIAGE.jeuxmiagiques.service.OrganisateurService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/organisateurs")
public class OrganisateurController {

    private OrganisateurService organisateurService;
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public OrganisateurController(OrganisateurService organisateurService, UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.organisateurService = organisateurService;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }
    @GetMapping
    public List<Organisateur> getAllOrganisateurs() {
        return organisateurService.findAll();
    }

    @GetMapping("/{id}")
    public Organisateur getOrganisateurById(@PathVariable int id) {
        return organisateurService.findById(id);
    }

    @PostMapping
    public Organisateur createOrganisateur(@RequestBody Organisateur organisateur) {
        organisateur.setUserRole("organisateur");
        return organisateurService.save(organisateur);
    }

    @PutMapping("/{id}")
    public Organisateur updateOrganisateur(@PathVariable int id, @RequestBody Organisateur organisateur) {
        // Get the organisateur by id
        Organisateur existingOrganisateur = organisateurService.findById(id);
        // Update the organisateur fields with the new values from the request body
        if (organisateur.getNom() != null) {
            existingOrganisateur.setNom(organisateur.getNom());
        }
        if (organisateur.getPrenom() != null) {
            existingOrganisateur.setPrenom(organisateur.getPrenom());
        }
        if (organisateur.getEmail() != null) {
            existingOrganisateur.setEmail(organisateur.getEmail());
        }
        if (organisateur.getPassword() != null) {
            existingOrganisateur.setPassword(passwordEncoder.encode(organisateur.getPassword()));
        }
        if (organisateur.getRole() != null) {
            existingOrganisateur.setRole(organisateur.getRole());
        }
        //if (organisateur.getUserRole() != null) {
        //    existingOrganisateur.setUserRole(organisateur.getUserRole());
        //}
        userRepository.save(existingOrganisateur);
        return organisateurService.save(existingOrganisateur);
    }

    @DeleteMapping("/{id}")
    public void deleteOrganisateur(@PathVariable int id) {
        organisateurService.deleteById(id);
    }
}
