package com.library.kodillalibrary.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class BooksLoansDto {
    private Long copieId;
    private Long titleId;
    private LocalDate loanedDate;
    private LocalDate returnedDate;
}
