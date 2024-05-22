package com.MIAGE.jeuxmiagiques.service;

import com.MIAGE.jeuxmiagiques.model.Spectateur;
import com.MIAGE.jeuxmiagiques.repository.SpectateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpectateurService {
    @Autowired
    private static SpectateurRepository spectateurRepository;

    public List<Spectateur> findAll() {
        return spectateurRepository.findAll();
    }

    public Spectateur findById(int id) {
        return spectateurRepository.findById(id).orElse(null);
    }

    public Spectateur save(Spectateur spectateur) {
        return spectateurRepository.save(spectateur);
    }

    public void deleteById(int id) {
        spectateurRepository.deleteById(id);
    }
}
