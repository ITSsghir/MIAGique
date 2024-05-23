package com.MIAGE.jeuxmiagiques.controller;

import com.MIAGE.jeuxmiagiques.model.Organisateur;

import com.MIAGE.jeuxmiagiques.service.OrganisateurService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/organisateurs")
public class OrganisateurController {

    private OrganisateurService organisateurService;

    @Autowired
    public OrganisateurController(OrganisateurService organisateurService) {
        this.organisateurService = organisateurService;
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
        organisateur.setRole("ORGANISATEUR");
        return organisateurService.save(organisateur);
    }

    @PutMapping("/{id}")
    public Organisateur updateOrganisateur(@PathVariable int id, @RequestBody Organisateur organisateur) {
        return organisateurService.save(organisateur);
    }

    @DeleteMapping("/{id}")
    public void deleteOrganisateur(@PathVariable int id) {
        organisateurService.deleteById(id);
    }
}
