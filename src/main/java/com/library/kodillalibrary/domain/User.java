package com.library.kodillalibrary.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "USERS")
public class User {

    private int userId;
    private String firstName;
    private String secondName;
    private Date accountCreated;

    public User(String firstName, String secondName) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.accountCreated = new Date();
    }

    public User() {
    }

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ID", unique = true)
    public int getUserId() {
        return userId;
    }

    @Column(name = "FIRSTNAME")
    public String getFirstName() {
        return firstName;
    }

    @Column(name = "LASTNAME")
    public String getSecondName() {
        return secondName;
    }

    @NotNull
    @Column(name = "CREATED")
    public Date getAccountCreated() {
        return accountCreated;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public void setAccountCreated(Date accountCreated) {
        this.accountCreated = accountCreated;
    }
}
