package com.example.fame_care;

public class AnimalHarvestMethods {
    private int id;
    private String aType, pType, aSection, aDate, aAmount;

    public AnimalHarvestMethods(){

    }

    public AnimalHarvestMethods(int id, String aType, String pType, String aSection, String aDate, String aAmount) {
        this.id = id;
        this.aType = aType;
        this.pType = pType;
        this.aSection = aSection;
        this.aDate = aDate;
        this.aAmount = aAmount;
    }

    public AnimalHarvestMethods(String aType, String pType, String aSection, String aDate, String aAmount) {
        this.aType = aType;
        this.pType = pType;
        this.aSection = aSection;
        this.aDate = aDate;
        this.aAmount = aAmount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getaType() {
        return aType;
    }

    public void setaType(String aType) {
        this.aType = aType;
    }

    public String getpType() {
        return pType;
    }

    public void setpType(String pType) {
        this.pType = pType;
    }

    public String getaSection() {
        return aSection;
    }

    public void setaSection(String aSection) {
        this.aSection = aSection;
    }

    public String getaDate() {
        return aDate;
    }

    public void setaDate(String aDate) {
        this.aDate = aDate;
    }

    public String getaAmount() {
        return aAmount;
    }

    public void setaAmount(String aAmount) {
        this.aAmount = aAmount;
    }
}
