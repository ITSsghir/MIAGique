package com.MIAGE.jeuxmiagiques.translationUnits;

import com.MIAGE.jeuxmiagiques.model.User;

public class ParticipantById extends User {

    private String nom;
    private String prenom;
    private String email;
    private String password;
    private int delegationId;

    // Constructors
    public ParticipantById(String nom, String prenom, String email, int delegationId, String password) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.delegationId = delegationId;
        this.password = password;
    }

    // Getters

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getEmail() {
        return email;
    }

    public int getDelegationId() {
        return delegationId;
    }

    public String getPassword() {
        return password;
    }

    // Setters
    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDelegationId(int delegationId) {
        this.delegationId = delegationId;
    }
}
