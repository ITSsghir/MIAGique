package com.MIAGE.jeuxmiagiques.controller;

import com.MIAGE.jeuxmiagiques.model.Resultat;
import com.MIAGE.jeuxmiagiques.service.ResultatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/resultats")
public class ResultatController {
    @Autowired
    private ResultatService resultatService;

    @GetMapping
    public List<Resultat> getAllResultats() {
        return resultatService.findAll();
    }

    @GetMapping("/{id}")
    public Resultat getResultatById(@PathVariable int id) {
        return resultatService.findById(id);
    }

    @PostMapping
    public Resultat createResultat(@RequestBody Resultat resultat) {
        return resultatService.save(resultat);
    }

    @PutMapping("/{id}")
    public Resultat updateResultat(@PathVariable int id, @RequestBody Resultat resultat) {
        return resultatService.save(resultat);
    }

    @DeleteMapping("/{id}")
    public void deleteResultat(@PathVariable int id) {
        resultatService.deleteById(id);
    }
}
