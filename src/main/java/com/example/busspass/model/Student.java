package com.example.busspass.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long stdid;

    @NotBlank
    private String name;

    @NotBlank
    private String regnumber;

    @Positive
    private int year;

    @NotBlank
    private String dept;

    @NotBlank
    private String phone;

    @NotBlank
    @Email
    private String email;

    private String password;

    public Student() {
    }

    public Student(Long stdid, String name, String regnumber, int year,
                   String dept, String phone, String email, String password) {
        this.stdid = stdid;
        this.name = name;
        this.regnumber = regnumber;
        this.year = year;
        this.dept = dept;
        this.phone = phone;
        this.email = email;
        this.password = password;
    }

    public Long getStdid() {
        return stdid;
    }

    public void setStdid(Long stdid) {
        this.stdid = stdid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegnumber() {
        return regnumber;
    }

    public void setRegnumber(String regnumber) {
        this.regnumber = regnumber;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}