package com.MIAGE.jeuxmiagiques.controller;

import com.MIAGE.jeuxmiagiques.model.InfrastructureSportive;

import com.MIAGE.jeuxmiagiques.service.InfrastructureSportiveService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/infrastructuresportives")
public class InfrastructureSportiveController {

    private InfrastructureSportiveService infrastructureSportiveService;

    @Autowired
    public InfrastructureSportiveController(InfrastructureSportiveService infrastructureSportiveService) {
        this.infrastructureSportiveService = infrastructureSportiveService;
    }
    @GetMapping
    public List<InfrastructureSportive> getAllInfrastructureSportives() {
        return infrastructureSportiveService.findAll();
    }

    @GetMapping("/{id}")
    public InfrastructureSportive getInfrastructureSportiveById(@PathVariable int id) {
        return infrastructureSportiveService.findById(id);
    }

    @PostMapping
    public InfrastructureSportive createInfrastructureSportive(@RequestBody InfrastructureSportive infrastructureSportive) {
        return infrastructureSportiveService.save(infrastructureSportive);
    }

    @PutMapping("/{id}")
    public InfrastructureSportive updateInfrastructureSportive(@PathVariable int id, @RequestBody InfrastructureSportive infrastructureSportive) {
        InfrastructureSportive existingInfrastructureSportive = infrastructureSportiveService.findById(id);
        if (infrastructureSportive.getNom() != null) {
            existingInfrastructureSportive.setNom(infrastructureSportive.getNom());
        }
        if (infrastructureSportive.getAdresse() != null) {
            existingInfrastructureSportive.setAdresse(infrastructureSportive.getAdresse());
        }
        if (infrastructureSportive.getCapacite() != 0) {
            existingInfrastructureSportive.setCapacite(infrastructureSportive.getCapacite());
        }
        return infrastructureSportiveService.save(existingInfrastructureSportive);
    }

    @DeleteMapping("/{id}")
    public void deleteInfrastructureSportive(@PathVariable int id) {
        infrastructureSportiveService.deleteById(id);
    }
}
