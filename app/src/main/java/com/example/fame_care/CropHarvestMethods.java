package com.example.fame_care;

public class CropHarvestMethods {
    private int id;
    private String cType, cSection, cDate, cAmount, cCondition;

    public CropHarvestMethods() {
    }

    public CropHarvestMethods(int id, String cType, String cSection, String cDate, String cAmount, String cCondition) {
        this.id = id;
        this.cType = cType;
        this.cSection = cSection;
        this.cDate = cDate;
        this.cAmount = cAmount;
        this.cCondition = cCondition;
    }

    public CropHarvestMethods(String cType, String cSection, String cDate, String cAmount, String cCondition) {
        this.cType = cType;
        this.cSection = cSection;
        this.cDate = cDate;
        this.cAmount = cAmount;
        this.cCondition = cCondition;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getcType() {
        return cType;
    }

    public void setcType(String cType) {
        this.cType = cType;
    }

    public String getcSection() {
        return cSection;
    }

    public void setcSection(String cSection) {
        this.cSection = cSection;
    }

    public String getcDate() {
        return cDate;
    }

    public void setcDate(String cDate) {
        this.cDate = cDate;
    }

    public String getcAmount() {
        return cAmount;
    }

    public void setcAmount(String cAmount) {
        this.cAmount = cAmount;
    }

    public String getcCondition() {
        return cCondition;
    }

    public void setcCondition(String cCondition) {
        this.cCondition = cCondition;
    }
}
