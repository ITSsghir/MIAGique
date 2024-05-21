package com.MIAGE.jeuxmiagiques.service;

import com.MIAGE.jeuxmiagiques.model.Delegation;
import com.MIAGE.jeuxmiagiques.repository.DelegationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DelegationService {
    @Autowired
    private DelegationRepository delegationRepository;

    public List<Delegation> findAll() {
        return delegationRepository.findAll();
    }

    public Delegation findById(Long id) {
        return delegationRepository.findById(id).orElse(null);
    }

    public Delegation save(Delegation delegation) {
        return delegationRepository.save(delegation);
    }

    public void deleteById(Long id) {
        delegationRepository.deleteById(id);
    }
}
