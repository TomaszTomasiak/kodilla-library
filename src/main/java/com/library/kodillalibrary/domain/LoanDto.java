package com.library.kodillalibrary.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class LoanDto {
    private int loanId;
    private TitleCopy titleCopy;
    private LibraryUser libraryUser;
    private LocalDate loanedDate;
    private LocalDate returnedDate;
}
