package com.example.fame_care;

public class EmployeeModelClass {

    Integer id;
    String employeeid, name, nic, gender, contactno;

    public EmployeeModelClass(){

    }

    public EmployeeModelClass(int id, String employeeid, String name, String nic, String gender, String contactno) {
        this.id = id;
        this.employeeid = employeeid;
        this.name = name;
        this.nic = nic;
        this.gender = gender;
        this.contactno = contactno;
    }

    public EmployeeModelClass(String employeeid, String name, String nic, String gender, String contactno) {
        this.employeeid = employeeid;
        this.name = name;
        this.nic = nic;
        this.gender = gender;
        this.contactno = contactno;
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

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getNic() {

        return nic;
    }

    public void setNic(String nic) {

        this.nic = nic;
    }

    public String getGender() {

        return gender;
    }

    public void setGender(String gender) {

        this.gender = gender;
    }

    public String getContactno() {

        return contactno;
    }

    public void setContactno(String contactno) {

        this.contactno = contactno;
    }
}
