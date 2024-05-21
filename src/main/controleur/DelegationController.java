package com.MIAGE.jeuxmiagiques.controller;

import com.MIAGE.jeuxmiagiques.model.Delegation;
import com.MIAGE.jeuxmiagiques.service.DelegationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/delegations")
public class DelegationController {
    @Autowired
    private DelegationService delegationService;

    @GetMapping
    public List<Delegation> getAllDelegations() {
        return delegationService.findAll();
    }

    @GetMapping("/{id}")
    public Delegation getDelegationById(@PathVariable Long id) {
        return delegationService.findById(id);
    }

    @PostMapping
    public Delegation createDelegation(@RequestBody Delegation delegation) {
        return delegationService.save(delegation);
    }

    @PutMapping("/{id}")
    public Delegation updateDelegation(@PathVariable Long id, @RequestBody Delegation delegation) {
        delegation.setId(id);
        return delegationService.save(delegation);
    }

    @DeleteMapping("/{id}")
    public void deleteDelegation(@PathVariable Long id) {
        delegationService.deleteById(id);
    }
}
