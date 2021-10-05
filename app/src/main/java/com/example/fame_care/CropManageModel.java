package com.example.fame_care;

public class CropManageModel {
    private int id;
    private String section, croptype, lpdate,dpdate;

    public CropManageModel() {

    }

    public CropManageModel(int id, String section, String croptype, String lpdate, String dpdate) {
        this.id = id;
        this.section = section;
        this.croptype = croptype;
        this.lpdate = lpdate;
        this.dpdate = dpdate;
    }

    public CropManageModel( String section, String croptype, String lpdate, String dpdate) {
        this.section = section;
        this.croptype = croptype;
        this.lpdate = lpdate;
        this.dpdate = dpdate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSection(){
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getCroptype() {
        return croptype;
    }

    public void setCroptype(String croptype) {
        this.croptype = croptype;
    }

    public String getLpdate() {
        return lpdate;
    }

    public void setLpdate(String lpdate) {
        this.lpdate = lpdate;
    }

    public String getDpdate() {
        return dpdate;
    }

    public void setDpdate(String dpdate) {
        this.dpdate = dpdate;
    }
}
