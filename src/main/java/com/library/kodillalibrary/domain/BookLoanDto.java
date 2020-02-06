package com.library.kodillalibrary.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import java.time.LocalDate;

@Getter
@AllArgsConstructor // konstruktor z wszystkich elementów????
public class BookLoanDto {
    private int loanId;
    private BookCopy bookCopy;
    private LibraryUser libraryUser;
    private LocalDate loanedDate;
    private LocalDate returnedDate;
}
