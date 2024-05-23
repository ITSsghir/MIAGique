package com.MIAGE.jeuxmiagiques.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity
public class Participant extends User {

    @ManyToOne
    private Delegation delegation;

    // Constructors
    public Participant() {
        super();
    }

    // Getters
    public Delegation getDelegation() {
        return delegation;
    }

    // Setters
    public void setDelegation(Delegation delegation) {
        this.delegation = delegation;
    }
}
