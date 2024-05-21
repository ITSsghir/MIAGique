package com.MIAGE.jeuxmiagiques.service;

import com.MIAGE.jeuxmiagiques.model.Billet;
import com.MIAGE.jeuxmiagiques.repository.BilletRepository;
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

    public Billet findById(Long id) {
        return billetRepository.findById(id).orElse(null);
    }

    public Billet save(Billet billet) {
        return billetRepository.save(billet);
    }

    public void deleteById(Long id) {
        billetRepository.deleteById(id);
    }
}
