package com.MIAGE.jeuxmiagiques.controller;

import com.MIAGE.jeuxmiagiques.model.Spectateur;
import com.MIAGE.jeuxmiagiques.repository.SpectateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/spectateurs")
public class SpectateurController {
    @Autowired
    private SpectateurRepository spectateurRepository;


    @GetMapping
    public List<Spectateur> getAllSpectateurs() {
        return spectateurRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Spectateur> getSpectateurById(@PathVariable int id) {
        return spectateurRepository.findById(id);
    }

    @PostMapping
    public Spectateur createSpectateur(@RequestBody Spectateur spectateur) {
        return spectateurRepository.save(spectateur);
    }

    @PutMapping("/{id}")
    public Spectateur updateSpectateur(@PathVariable int id, @RequestBody Spectateur spectateur) {
        spectateur.setId(id);
        return spectateurRepository.save(spectateur);
    }

    @DeleteMapping("/{id}")
    public void deleteSpectateur(@PathVariable int id) {
        spectateurRepository.deleteById(id);
    }
}
