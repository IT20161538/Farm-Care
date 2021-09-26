package com.example.fame_care;

public class WorkSceduleModelClass {

    Integer id;
    String eid, section, work, date, time;

    public WorkSceduleModelClass(Integer id, String eid, String section, String work, String date, String time) {
        this.id = id;
        this.eid = eid;
        this.section = section;
        this.work = work;
        this.date = date;
        this.time = time;
    }

    public WorkSceduleModelClass() {
        this.eid = eid;
        this.section = section;
        this.work = work;
        this.date = date;
        this.time = time;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEid() {
        return eid;
    }

    public void setEid(String eid) {
        this.eid = eid;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
