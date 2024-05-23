package com.MIAGE.jeuxmiagiques.service;

import com.MIAGE.jeuxmiagiques.model.Billet;
import com.MIAGE.jeuxmiagiques.model.Epreuve;
import com.MIAGE.jeuxmiagiques.model.Spectateur;
import com.MIAGE.jeuxmiagiques.repository.BilletRepository;
import com.MIAGE.jeuxmiagiques.repository.EpreuveRepository;
import com.MIAGE.jeuxmiagiques.repository.SpectateurRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BilletService {
    @Autowired
    private BilletRepository billetRepository;

    public List<Billet> findAll() {
        return billetRepository.findAll();
    }

    public Billet findById(int id) {
        return billetRepository.findById(id).orElse(null);
    }
    // doesn't work
    public Billet save(Billet billet) {
        return billetRepository.save(billet);
    }

    public void deleteById(int id) {
        billetRepository.deleteById(id);
    }
}
