package com.library.kodillalibrary.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TitleCopyDto {
    private int copyId;
    private Title title;
    private String status;
    private List<Loan> copyLoans;
}
