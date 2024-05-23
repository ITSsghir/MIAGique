package com.MIAGE.jeuxmiagiques.controller;

import com.MIAGE.jeuxmiagiques.model.Billet;
import com.MIAGE.jeuxmiagiques.model.Epreuve;
import com.MIAGE.jeuxmiagiques.model.Spectateur;
import com.MIAGE.jeuxmiagiques.service.BilletService;
import com.MIAGE.jeuxmiagiques.service.EpreuveService;
import com.MIAGE.jeuxmiagiques.service.SpectateurService;
import com.MIAGE.jeuxmiagiques.translatorUnits.BilletById;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/billets")
public class BilletController {
    @Autowired
    private BilletService billetService;

    private EpreuveService epreuveService;
    private SpectateurService spectateurService;

    @Autowired
    public BilletController(EpreuveService epreuveService, SpectateurService spectateurService) {
        this.epreuveService = epreuveService;
        this.spectateurService = spectateurService;
    }

    @GetMapping
    public List<Billet> getAllBillets() {
        return billetService.findAll();
    }

    @GetMapping("/{id}")
    public Billet getBilletById(@PathVariable int id) {
        return billetService.findById(id);
    }

    @PostMapping
    public Billet createBillet(@RequestBody BilletById body) {
        Billet billet = new Billet();
        Epreuve epreuve = epreuveService.findById(body.getEpreuveId());
        Spectateur spectateur = spectateurService.findById(body.getSpectateurId());
        billet.setEpreuve(epreuve);
        billet.setSpectateur(spectateur);
        billet.setPrix(body.getPrix());
        billet.setEtat(body.getEtat());
        return billetService.save(billet);
    }

    @PutMapping("/{id}")
    public Billet updateBillet(@PathVariable int id, @RequestBody Billet billet) {
        return billetService.save(billet);
    }

    @DeleteMapping("/{id}")
    public void deleteBillet(@PathVariable int id) {
        billetService.deleteById(id);
    }
}
