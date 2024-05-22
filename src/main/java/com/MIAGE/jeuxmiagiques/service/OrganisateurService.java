package com.MIAGE.jeuxmiagiques.service;

import com.MIAGE.jeuxmiagiques.model.Organisateur;
import com.MIAGE.jeuxmiagiques.repository.OrganisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganisateurService {
    @Autowired
    private OrganisateurRepository organisateurRepository;

    public List<Organisateur> findAll() {
        return organisateurRepository.findAll();
    }

    public Organisateur findById(int id) {
        return organisateurRepository.findById(id).orElse(null);
    }

    public Organisateur save(Organisateur organisateur) {
        return organisateurRepository.save(organisateur);
    }

    public void deleteById(int id) {
        organisateurRepository.deleteById(id);
    }
}
