package com.library.kodillalibrary.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Getter
public class LibraryUserDto {
    private int userId;
    private String firstName;
    private String secondName;
    private LocalDate accountCreated;
    private List<BookLoan> loans;

    /*
    public LibraryUserDto(int userId, String firstName, String secondName, LocalDate accountCreated) {
        this.userId = userId;
        this.firstName = firstName;
        this.secondName = secondName;
        this.accountCreated = accountCreated;
    }

     */
}
