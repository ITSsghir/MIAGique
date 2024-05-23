package com.MIAGE.jeuxmiagiques.model;

import jakarta.persistence.Entity;


@Entity
public class Organisateur extends User {

    private String nom;
    private String prenom;
    private String role; // "organisateur" ou "controleur"

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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}