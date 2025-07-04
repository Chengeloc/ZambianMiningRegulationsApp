package com.charleschildumba.miningregulations;

public class MiningRegulation {
    private String regulation;
    private String position;
    private String appointedBy;
    private String legalResponsibility;
    
    public MiningRegulation(String regulation, String position, String appointedBy, String legalResponsibility) {
        this.regulation = regulation;
        this.position = position;
        this.appointedBy = appointedBy;
        this.legalResponsibility = legalResponsibility;
    }
    
    // Getters
    public String getRegulation() { return regulation; }
    public String getPosition() { return position; }
    public String getAppointedBy() { return appointedBy; }
    public String getLegalResponsibility() { return legalResponsibility; }
    
    // Setters
    public void setRegulation(String regulation) { this.regulation = regulation; }
    public void setPosition(String position) { this.position = position; }
    public void setAppointedBy(String appointedBy) { this.appointedBy = appointedBy; }
    public void setLegalResponsibility(String legalResponsibility) { this.legalResponsibility = legalResponsibility; }
    
    @Override
    public String toString() {
        return position + " (" + regulation + ")";
    }
}

