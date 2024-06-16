package com.MIAGE.jeuxmiagiques.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class Epreuve {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;
    private Date date;
    
    @ManyToOne
    @JoinColumn(name = "infrastructure_id")
    private InfrastructureSportive infrastructure;
    
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

    public InfrastructureSportive getInfrastructure() {
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

    public void setInfrastructure(InfrastructureSportive infrastructure) {
        this.infrastructure = infrastructure;
    }

    public void setNombrePlaces(int nombrePlaces) {
        this.nombrePlaces = nombrePlaces;
    }
}
