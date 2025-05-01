package com.example.employee_attendance_leave_system.model;

import java.util.Date;

public class Employee {
    private int id;
    private String name;
    private String email;
    private Date hireDate;

    public Employee() {}

    public Employee(int id, String name, String email, Date hireDate) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.hireDate = hireDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", hireDate=" + hireDate +
                '}';
    }
}
