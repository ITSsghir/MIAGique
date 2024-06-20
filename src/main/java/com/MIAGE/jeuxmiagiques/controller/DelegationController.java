package com.MIAGE.jeuxmiagiques.controller;

import com.MIAGE.jeuxmiagiques.model.Delegation;

import com.MIAGE.jeuxmiagiques.service.DelegationService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/delegations")
public class DelegationController {

    private DelegationService delegationService;

    @Autowired
    public DelegationController(DelegationService delegationService) {
        this.delegationService = delegationService;
    }
    @GetMapping
    public List<Delegation> getAllDelegations() {
        return delegationService.findAll();
    }

    @GetMapping("/{id}")
    public Delegation getDelegationById(@PathVariable int id) {
        return delegationService.findById(id);
    }

    @PostMapping
    public Delegation createDelegation(@RequestBody Delegation delegation) {
        return delegationService.save(delegation);
    }

    @PutMapping("/{id}")
    public Delegation updateDelegation(@PathVariable int id, @RequestBody Delegation delegation) {
        Delegation existingDelegation = delegationService.findById(id);
        if (existingDelegation == null) {
            return delegationService.save(delegation);
        }
        if (existingDelegation.getNom() != null) {
            existingDelegation.setNom(delegation.getNom());
        }
        if (existingDelegation.getNombreMedailleOr() != 0) {
            existingDelegation.setNombreMedailleOr(delegation.getNombreMedailleOr());
        }
        if (existingDelegation.getNombreMedailleArgent() != 0) {
            existingDelegation.setNombreMedailleArgent(delegation.getNombreMedailleArgent());
        }
        if (existingDelegation.getNombreMedailleBronze() != 0) {
            existingDelegation.setNombreMedailleBronze(delegation.getNombreMedailleBronze());
        }
        return delegationService.save(existingDelegation);
    }

    @DeleteMapping("/{id}")
    public void deleteDelegation(@PathVariable int id) {
        delegationService.deleteById(id);
    }
}
