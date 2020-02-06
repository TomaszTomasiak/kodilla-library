package com.library.kodillalibrary.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "USERS")
public class LibraryUser {

    private int userId;
    private String firstName;
    private String secondName;
    private LocalDate accountCreated;
    private List<BookLoan> loans = new ArrayList<>();

/*
    public LibraryUser(String firstName, String secondName) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.accountCreated = LocalDate.now();
    }

    public LibraryUser() {
    }

 */

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "USER_ID", unique = true)
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
    public LocalDate getAccountCreated() {
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

    public void setAccountCreated(LocalDate accountCreated) {
        this.accountCreated = accountCreated;
    }

    @OneToMany(
            targetEntity = BookLoan.class,
            mappedBy = "libraryUser",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    public List<BookLoan> getLoans() {
        return loans;
    }

    public void setLoans(List<BookLoan> loans) {
        this.loans = loans;
    }
}
