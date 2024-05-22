package com.MIAGE.jeuxmiagiques.service;

import com.MIAGE.jeuxmiagiques.model.Resultat;
import com.MIAGE.jeuxmiagiques.repository.ResultatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResultatService {
    @Autowired
    private ResultatRepository resultatRepository;

    public List<Resultat> findAll() {
        return resultatRepository.findAll();
    }

    public Resultat findById(int id) {
        return resultatRepository.findById(id).orElse(null);
    }

    public Resultat save(Resultat resultat) {
        return resultatRepository.save(resultat);
    }

    public void deleteById(int id) {
        resultatRepository.deleteById(id);
    }
}
