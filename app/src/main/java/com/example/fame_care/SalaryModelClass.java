package com.example.fame_care;

public class SalaryModelClass {

    Integer id;
    String employeeid, basicsalary, othours, totalsalary;

    public SalaryModelClass(){

    }

    public SalaryModelClass(Integer id, String employeeid, String basicsalary, String othours, String totalsalary) {
        this.id = id;
        this.employeeid = employeeid;
        this.basicsalary = basicsalary;
        this.othours = othours;
        this.totalsalary = totalsalary;
    }

    public SalaryModelClass(String employeeid, String basicsalary, String othours, String totalsalary) {
        this.employeeid = employeeid;
        this.basicsalary = basicsalary;
        this.othours = othours;
        this.totalsalary = totalsalary;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmployeeid() {
        return employeeid;
    }

    public void setEmployeeid(String employeeid) {
        this.employeeid = employeeid;
    }

    public String getBasicsalary() {
        return basicsalary;
    }

    public void setBasicsalary(String basicsalary) {
        this.basicsalary = basicsalary;
    }

    public String getOthours() {
        return othours;
    }

    public void setOthours(String othours) {
        this.othours = othours;
    }

    public String getTotalsalary() {
        return totalsalary;
    }

    public void setTotalsalary(String totalsalary) {
        this.totalsalary = totalsalary;
    }
}
