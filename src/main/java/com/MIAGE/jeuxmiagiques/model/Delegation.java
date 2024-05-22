package com.MIAGE.jeuxmiagiques.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;


@Entity
public class Delegation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;
    private int nombreMedailleOr;
    private int nombreMedailleArgent;
    private int nombreMedailleBronze;

    @OneToMany(mappedBy = "delegation")
    private List<Participant> participants;

    // Constructors
    public Delegation() {
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public int getNombreMedailleOr() {
        return nombreMedailleOr;
    }

    public int getNombreMedailleArgent() {
        return nombreMedailleArgent;
    }

    public int getNombreMedailleBronze() {
        return nombreMedailleBronze;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setNombreMedailleOr(int nombreMedailleOr) {
        this.nombreMedailleOr = nombreMedailleOr;
    }

    public void setNombreMedailleArgent(int nombreMedailleArgent) {
        this.nombreMedailleArgent = nombreMedailleArgent;
    }

    public void setNombreMedailleBronze(int nombreMedailleBronze) {
        this.nombreMedailleBronze = nombreMedailleBronze;
    }
}
