package com.library.kodillalibrary.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@AllArgsConstructor
public class LoanDto {
    private int loanId;
    private int copyId;
    private int userId;
    private LocalDate loanedDate;
    private LocalDate returnedDate;
}
