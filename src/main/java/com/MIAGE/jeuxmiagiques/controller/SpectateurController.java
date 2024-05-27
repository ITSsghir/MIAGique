package com.MIAGE.jeuxmiagiques.controller;

import com.MIAGE.jeuxmiagiques.model.Spectateur;

import com.MIAGE.jeuxmiagiques.service.SpectateurService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/spectateurs")
public class SpectateurController {

    private SpectateurService spectateurService;

    @Autowired
    public SpectateurController(SpectateurService spectateurService) {
        this.spectateurService = spectateurService;
    }


    @GetMapping
    public List<Spectateur> getAllSpectateurs() {
        return spectateurService.findAll();
    }

    @GetMapping("/{id}")
    public Spectateur getSpectateurById(@PathVariable int id) {
        return spectateurService.findById(id);
    }

    @PostMapping
    public Spectateur createSpectateur(@RequestBody Spectateur spectateur) {
        spectateur.setUserRole("spectateur");
        return spectateurService.save(spectateur);
    }

    @PutMapping("/{id}")
    public Spectateur updateSpectateur(@PathVariable int id, @RequestBody Spectateur spectateur) {
        // Get the spectateur by id
        Spectateur existingSpectateur = spectateurService.findById(id);
        // Update the spectateur fields with the new values from the request body
        if (spectateur.getNom() != null) {
            existingSpectateur.setNom(spectateur.getNom());
        }
        if (spectateur.getPrenom() != null) {
            existingSpectateur.setPrenom(spectateur.getPrenom());
        }
        if (spectateur.getEmail() != null) {
            existingSpectateur.setEmail(spectateur.getEmail());
        }
        return spectateurService.save(spectateur);
    }

    @DeleteMapping("/{id}")
    public void deleteSpectateur(@PathVariable int id) {
        spectateurService.deleteById(id);
    }
}
