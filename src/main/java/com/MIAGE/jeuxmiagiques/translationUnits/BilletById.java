package com.MIAGE.jeuxmiagiques.translationUnits;

public class BilletById {
    // Attributes
    private int epreuveId;
    private int spectateurId;
    private double prix;
    private String etat; // "valide", "annulé"

    // Constructor
    public BilletById(int epreuveId, int spectateurId, double prix, String etat) {
        this.epreuveId = epreuveId;
        this.spectateurId = spectateurId;
        this.prix = prix;
        this.etat = etat;
    }

    // Getters
    public int getEpreuveId() {
        return epreuveId;
    }

    public int getSpectateurId() {
        return spectateurId;
    }

    public double getPrix() {
        return prix;
    }

    public String getEtat() {
        return etat;
    }

    // Setters
    public void setEpreuveId(int epreuveId) {
        this.epreuveId = epreuveId;
    }

    public void setSpectateurId(int spectateurId) {
        this.spectateurId = spectateurId;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }
}
