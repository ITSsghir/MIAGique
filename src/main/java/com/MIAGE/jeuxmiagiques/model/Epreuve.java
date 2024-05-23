package com.MIAGE.jeuxmiagiques.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class Epreuve {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;
    private Date date;
    private String infrastructure;
    private int nombrePlaces;

    public Epreuve() {
    }
    // Getters

    public int getId() {
        return id;
    }
    
    public String getNom() {
        return nom;
    }

    public Date getDate() {
        return date;
    }

    public String getInfrastructure() {
        return infrastructure;
    }

    public int getNombrePlaces() {
        return nombrePlaces;
    }

    // Setters
    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setInfrastructure(String infrastructure) {
        this.infrastructure = infrastructure;
    }

    public void setNombrePlaces(int nombrePlaces) {
        this.nombrePlaces = nombrePlaces;
    }


}
