package com.MIAGE.jeuxmiagiques.service;

import com.MIAGE.jeuxmiagiques.model.Billet;
import com.MIAGE.jeuxmiagiques.repository.BilletRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BilletService {

    private BilletRepository billetRepository;

    @Autowired
    public BilletService(BilletRepository billetRepository) {
        this.billetRepository = billetRepository;
    }
    public List<Billet> findAll() {
        return billetRepository.findAll();
    }

    public Billet findById(int id) {
        return billetRepository.findById(id).orElse(null);
    }
    public Billet save(Billet billet) {
        return billetRepository.save(billet);
    }

    public void deleteById(int id) {
        billetRepository.deleteById(id);
    }
}
