package com.MIAGE.jeuxmiagiques.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity
public class Participant extends User {

    private String nom;
    private String prenom;

    @ManyToOne
    private Delegation delegation;

    // Constructors
    public Participant() {
        super();
    }

    // Getters
    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public Delegation getDelegation() {
        return delegation;
    }

    // Setters
    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setDelegation(Delegation delegation) {
        this.delegation = delegation;
    }
}
