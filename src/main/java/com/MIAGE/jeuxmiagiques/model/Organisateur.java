package com.MIAGE.jeuxmiagiques.model;

import jakarta.persistence.Entity;


@Entity
public class Organisateur extends User {

    private String role; // "organisateur" ou "controleur"

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}