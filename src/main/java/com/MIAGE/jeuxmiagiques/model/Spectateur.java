package com.MIAGE.jeuxmiagiques.model;

import jakarta.persistence.Entity;

@Entity
public class Spectateur extends User {

    // Constructors

    public Spectateur() {
        super();
    }

    public Spectateur(String nom, String prenom, String email, String password, String userRole) {
        setNom(nom);
        setPrenom(prenom);
        setEmail(email);
        setPassword(password);
        setUserRole(userRole);
    }
}
