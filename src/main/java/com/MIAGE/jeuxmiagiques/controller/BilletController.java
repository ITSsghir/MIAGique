package com.MIAGE.jeuxmiagiques.controller;

import com.MIAGE.jeuxmiagiques.model.Billet;
import com.MIAGE.jeuxmiagiques.model.Epreuve;
import com.MIAGE.jeuxmiagiques.model.Spectateur;
import com.MIAGE.jeuxmiagiques.repository.EpreuveRepository;
import com.MIAGE.jeuxmiagiques.repository.SpectateurRepository;
import com.MIAGE.jeuxmiagiques.service.BilletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/billets")
public class BilletController {
    @Autowired
    private BilletService billetService;

    private EpreuveRepository epreuveRepository;
    private SpectateurRepository spectateurRepository;

    @GetMapping
    public List<Billet> getAllBillets() {
        return billetService.findAll();
    }

    @GetMapping("/{id}")
    public Billet getBilletById(@PathVariable int id) {
        return billetService.findById(id);
    }

    @PostMapping
    public Billet createBillet(@RequestBody Object body) {
        Epreuve epreuve = epreuveRepository.findById(body.epreuveId).orElse(null);
        Spectateur spectateur = spectateurRepository.findById(body.spectateurId).orElse(null);
        Billet billet1 = new Billet();
        billet1.setId(body.id);
        billet1.setEtat(body.etat);
        billet1.setPrix(body.prix);
        billet1.setEpreuve(epreuve);
        billet1.setSpectateur(spectateur);
        return billetService.save(billet1);
    }

    @PutMapping("/{id}")
    public Billet updateBillet(@PathVariable int id, @RequestBody Billet billet) {
        billet.setId(id);
        return billetService.save(billet);
    }

    @DeleteMapping("/{id}")
    public void deleteBillet(@PathVariable int id) {
        billetService.deleteById(id);
    }
}
