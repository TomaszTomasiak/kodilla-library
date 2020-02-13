package com.library.kodillalibrary.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "USERS")
public class LibraryUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "USER_ID", unique = true)
    private int userId;


    @Column(name = "FIRSTNAME")
    private String firstName;


    @Column(name = "LASTNAME")
    private String lastName;

    @NotNull
    @Column(name = "CREATED")
    private LocalDate accountCreated;

    @OneToMany(
            targetEntity = Loan.class,
            mappedBy = "libraryUser",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Loan> userLoans = new ArrayList<>();

    public LibraryUser(int userId, String firstName, String lastName, LocalDate accountCreated, List<Loan> userLoans) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.accountCreated = LocalDate.now();
        this.userLoans = userLoans;
    }

    public LibraryUser() {
    }
}
