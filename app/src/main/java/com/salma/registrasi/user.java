package com.salma.registrasi;

import java.io.Serializable;

public class user implements Serializable {
    private String nim;
    private String fullName;
    private String email;
    private String phone;
    private String faculty;
    private String major;

    public user(String nim, String fullName, String email, String phone, String faculty, String major) {
        this.nim = nim;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.faculty = faculty;
        this.major = major;
    }

    public String getNim() {
        return nim;
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getFaculty() {
        return faculty;
    }

    public String getMajor() {
        return major;
    }
}
