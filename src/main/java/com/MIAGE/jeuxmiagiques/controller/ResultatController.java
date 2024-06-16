package com.MIAGE.jeuxmiagiques.controller;

import com.MIAGE.jeuxmiagiques.model.Resultat;
import com.MIAGE.jeuxmiagiques.model.Epreuve;
import com.MIAGE.jeuxmiagiques.model.Participant;

import com.MIAGE.jeuxmiagiques.service.ResultatService;

import com.MIAGE.jeuxmiagiques.translationUnits.ResultatById;

import com.MIAGE.jeuxmiagiques.repository.EpreuveRepository;
import com.MIAGE.jeuxmiagiques.repository.ParticipantRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/resultats")
public class ResultatController {

    private final ResultatService resultatService;
    private final EpreuveRepository epreuveRepository;
    private final ParticipantRepository participantRepository;

    @Autowired
    public ResultatController(ResultatService resultatService, EpreuveRepository epreuveRepository, ParticipantRepository participantRepository) {
        this.resultatService = resultatService;
        this.epreuveRepository = epreuveRepository;
        this.participantRepository = participantRepository;
    }

    @GetMapping
    public List<Resultat> getAllResultats() {
        return resultatService.findAll();
    }

    @GetMapping("/{id}")
    public Resultat getResultatById(@PathVariable int id) {
        return resultatService.findById(id);
    }

    @PostMapping
    public Resultat createResultat(@RequestBody ResultatById resultatById) {
        Epreuve epreuve = epreuveRepository.findById(resultatById.getEpreuveId()).orElse(null);
        Participant participant = participantRepository.findById(resultatById.getParticipantId()).orElse(null);
        if (epreuve == null || participant == null) return null;
        // Create the Resultat object
        Resultat resultat = new Resultat();
        resultat.setEpreuve(epreuve);
        resultat.setParticipant(participant);
        resultat.setPosition(resultatById.getPosition());
        resultat.setTemps(resultatById.getTemps());
        return resultatService.save(resultat);
    }

    @PutMapping("/{id}")
    public Resultat updateResultat(@PathVariable int id, @RequestBody ResultatById resultatById) {
        Resultat resultat = resultatService.findById(id);
        Epreuve epreuve = epreuveRepository.findById(resultatById.getEpreuveId()).orElse(null);
        if (epreuve != null) resultat.setEpreuve(epreuve);
        Participant participant = participantRepository.findById(resultatById.getParticipantId()).orElse(null);
        if (participant != null) resultat.setParticipant(participant);
        if (resultatById.getPosition() != 0) resultat.setPosition(resultatById.getPosition());
        if (resultatById.getTemps() != null) resultat.setTemps(resultatById.getTemps());
        return resultatService.save(resultat);
    }

    @DeleteMapping("/{id}")
    public void deleteResultat(@PathVariable int id) {
        resultatService.deleteById(id);
    }
}
