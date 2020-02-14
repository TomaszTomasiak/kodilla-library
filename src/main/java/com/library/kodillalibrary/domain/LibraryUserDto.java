package com.library.kodillalibrary.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class LibraryUserDto {
    private int userId;
    private String firstName;
    private String lastName;
    private LocalDate accountCreated;
    private List<Loan> userLoans;
}
