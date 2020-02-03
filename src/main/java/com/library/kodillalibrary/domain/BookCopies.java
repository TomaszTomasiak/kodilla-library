package com.library.kodillalibrary.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class BookCopies {

    private LocalDate copieId;
    private LocalDate titleId;
    private String status;
}
