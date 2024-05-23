package com.MIAGE.jeuxmiagiques.model;

import jakarta.persistence.Entity;

@Entity
public class Spectateur extends User {

    private String nom;
    private String prenom;

    // Constructors

    public Spectateur() {
        super();
    }

    // Getters and setters

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
}
