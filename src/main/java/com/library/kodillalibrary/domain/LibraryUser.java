package com.library.kodillalibrary.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
@NoArgsConstructor
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

    @JsonIgnore
    @OneToMany(
            targetEntity = Loan.class,
            mappedBy = "libraryUser",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Loan> userLoans = new ArrayList<>();
}
