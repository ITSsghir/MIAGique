package com.MIAGE.jeuxmiagiques.controller;

import com.MIAGE.jeuxmiagiques.model.Resultat;
import com.MIAGE.jeuxmiagiques.model.Epreuve;
import com.MIAGE.jeuxmiagiques.model.Participant;

import com.MIAGE.jeuxmiagiques.service.ResultatService;
import com.MIAGE.jeuxmiagiques.service.EpreuveService;

import com.MIAGE.jeuxmiagiques.translationUnits.ResultatById;

import com.MIAGE.jeuxmiagiques.repository.ParticipantRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/resultats")
public class ResultatController {

    private ResultatService resultatService;
    private EpreuveService epreuveService;
    private ParticipantRepository participantRepository;

    @Autowired
    public ResultatController(ResultatService resultatService, EpreuveService epreuveService, ParticipantRepository participantRepository) {
        this.resultatService = resultatService;
        this.epreuveService = epreuveService;
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
        Resultat resultat = new Resultat();
        Epreuve epreuve = epreuveService.findById(resultatById.getEpreuveId());
        resultat.setEpreuve(epreuve);
        Participant participant = participantRepository.findById(resultatById.getParticipantId()).orElse(null);
        resultat.setParticipant(participant);
        resultat.setPosition(resultatById.getPosition());
        resultat.setTemps(resultatById.getTemps());
        return resultatService.save(resultat);
    }

    @PutMapping("/{id}")
    public Resultat updateResultat(@PathVariable int id, @RequestBody ResultatById resultatById) {
        Resultat resultat = resultatService.findById(id);
        Epreuve epreuve = epreuveService.findById(resultatById.getEpreuveId());
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
