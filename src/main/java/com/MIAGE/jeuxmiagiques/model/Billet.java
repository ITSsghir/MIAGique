package com.MIAGE.jeuxmiagiques.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Billet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private Epreuve epreuve;

    @ManyToOne
    private Spectateur spectateur;

    private double prix;

    private String etat; // "valide", "annulé"

    // Constructor
    public Billet(){
    }

    // Getters
    public int getId() {
        return id;
    }

    public Epreuve getEpreuve() {
        return epreuve;
    }

    public Spectateur getSpectateur() {
        return spectateur;
    }

    public double getPrix() {
        return prix;
    }

    public String getEtat() {
        return etat;
    }

    // Setters

    public void setId(int id) {
        this.id = id;
    }

    public void setEpreuve(Epreuve epreuve) {
        this.epreuve = epreuve;
    }

    public void setSpectateur(Spectateur spectateur) {
        this.spectateur = spectateur;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }
}
