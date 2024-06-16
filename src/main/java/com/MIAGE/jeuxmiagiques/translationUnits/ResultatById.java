package com.MIAGE.jeuxmiagiques.translationUnits;

public class ResultatById {

    // Attributes
    private int epreuveId;
    private int participantId;
    private String temps; // ou "points", selon le type d'épreuve
    private int position;

    // Constructor
    public ResultatById(int epreuveId, int participantId, String temps, int position) {
        this.epreuveId = epreuveId;
        this.participantId = participantId;
        this.temps = temps;
        this.position = position;
    }

    // Getters
    public int getEpreuveId() {
        return this.epreuveId;
    }

    public int getParticipantId() {
        return this.participantId;
    }

    public String getTemps() {
        return this.temps;
    }

    public int getPosition() {
        return this.position;
    }

    // Setters
    public void setEpreuveId(int epreuveId) {
        this.epreuveId = epreuveId;
    }

    public void setParticipantId(int participantId) {
        this.participantId = participantId;
    }

    public void setTemps(String temps) {
        this.temps = temps;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
