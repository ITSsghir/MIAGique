package com.MIAGE.jeuxmiagiques.service;

import com.MIAGE.jeuxmiagiques.model.InfrastructureSportive;
import com.MIAGE.jeuxmiagiques.repository.InfrastructureSportiveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InfrastructureSportiveService {
    @Autowired
    private InfrastructureSportiveRepository infrastructureSportiveRepository;

    public List<InfrastructureSportive> findAll() {
        return infrastructureSportiveRepository.findAll();
    }

    public InfrastructureSportive findById(int id) {
        return infrastructureSportiveRepository.findById(id).orElse(null);
    }

    public InfrastructureSportive save(InfrastructureSportive infrastructureSportive) {
        return infrastructureSportiveRepository.save(infrastructureSportive);
    }

    public void deleteById(int id) {
        infrastructureSportiveRepository.deleteById(id);
    }
}
