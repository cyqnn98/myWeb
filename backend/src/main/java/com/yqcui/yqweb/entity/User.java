package com.yqcui.yqweb.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "`Users`")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    @Column(name = "userName", nullable = false)
    private String name;
    @Column(name = "`phoneNumber`", nullable = false, unique = true)
    private long phoneNum;
    @Column(name = "`email`", nullable = false, unique = true)
    private String email;
    @Column(name = "`password`", nullable = false)
    private String password;
    @Column(name = "`dateOfBirth`", nullable = false)
    private String dateOfBirth;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(long phoneNum) {
        this.phoneNum = phoneNum;
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

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
