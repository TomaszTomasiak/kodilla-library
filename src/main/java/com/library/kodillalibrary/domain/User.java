package com.library.kodillalibrary.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor

public class User {

    private Long userId;
    private String firstName;
    private String secondName;
    private LocalDate accountCreated;
}
