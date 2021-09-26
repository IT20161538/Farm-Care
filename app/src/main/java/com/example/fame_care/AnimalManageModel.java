package com.example.fame_care;

public class AnimalManageModel {
    private int id;
    private String section, animalType, dateOfBirth,lvDate, dvDate,age;

    public AnimalManageModel() {
    }

    public AnimalManageModel(int id, String section, String animalType, String dateOfBirth, String lvDate, String dvDate, String age) {
        this.id = id;
        this.section = section;
        this.animalType = animalType;
        this.dateOfBirth = dateOfBirth;
        this.lvDate = lvDate;
        this.dvDate = dvDate;
        this.age = age;
    }

    public AnimalManageModel(String section, String animalType, String dateOfBirth, String lvDate, String dvDate, String age) {
        this.section = section;
        this.animalType = animalType;
        this.dateOfBirth = dateOfBirth;
        this.lvDate = lvDate;
        this.dvDate = dvDate;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getAnimalType() {
        return animalType;
    }

    public void setAnimalType(String animalType) {
        this.animalType = animalType;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getLvDate() {
        return lvDate;
    }

    public void setLvDate(String lvDate) {
        this.lvDate = lvDate;
    }

    public String getDvDate() {
        return dvDate;
    }

    public void setDvDate(String dvDate) {
        this.dvDate = dvDate;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
