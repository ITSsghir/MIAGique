package com.MIAGE.jeuxmiagiques.service;

import com.MIAGE.jeuxmiagiques.model.Epreuve;
import com.MIAGE.jeuxmiagiques.repository.EpreuveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EpreuveService {
    @Autowired
    private EpreuveRepository epreuveRepository;

    public List<Epreuve> findAll() {
        return epreuveRepository.findAll();
    }

    public Epreuve findById(int id) {
        return epreuveRepository.findById(id).orElse(null);
    }

    public Epreuve save(Epreuve epreuve) {
        return epreuveRepository.save(epreuve);
    }

    public void deleteById(int id) {
        epreuveRepository.deleteById(id);
    }
}
