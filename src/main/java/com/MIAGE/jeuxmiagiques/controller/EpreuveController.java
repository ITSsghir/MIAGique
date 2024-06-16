package com.MIAGE.jeuxmiagiques.controller;

import com.MIAGE.jeuxmiagiques.model.Epreuve;

import com.MIAGE.jeuxmiagiques.service.EpreuveService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/epreuves")
public class EpreuveController {

    private EpreuveService epreuveService;

    @Autowired
    public EpreuveController(EpreuveService epreuveService) {
        this.epreuveService = epreuveService;
    }
    @GetMapping
    public List<Epreuve> getAllEpreuves() {
        return epreuveService.findAll();
    }

    @GetMapping("/{id}")
    public Epreuve getEpreuveById(@PathVariable int id) {
        return epreuveService.findById(id);
    }

    @PostMapping
    public Epreuve createEpreuve(@RequestBody Epreuve epreuve) {
        return epreuveService.save(epreuve);
    }

    @PutMapping("/{id}")
    public Epreuve updateEpreuve(@PathVariable int id, @RequestBody Epreuve epreuve) {
        Epreuve existingEpreuve = epreuveService.findById(id);
        if (epreuve.getNom() != null) {
            existingEpreuve.setNom(epreuve.getNom());
        }
        if (epreuve.getDate() != null) {
            existingEpreuve.setDate(epreuve.getDate());
        }
        if (epreuve.getInfrastructure() != null) {
            existingEpreuve.setInfrastructure(epreuve.getInfrastructure());
        }
        if (epreuve.getNombrePlaces() != 0) {
            existingEpreuve.setNombrePlaces(epreuve.getNombrePlaces());
        }

        return epreuveService.save(existingEpreuve);
    }

    @DeleteMapping("/{id}")
    public void deleteEpreuve(@PathVariable int id) {
        epreuveService.deleteById(id);
    }
}
