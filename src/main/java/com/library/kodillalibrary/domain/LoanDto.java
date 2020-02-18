package com.library.kodillalibrary.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@AllArgsConstructor
public class LoanDto {
    private int loanId;
    private TitleCopy titleCopy;
    private LibraryUser libraryUser;
    private LocalDate loanedDate;
    private LocalDate returnedDate;
}
