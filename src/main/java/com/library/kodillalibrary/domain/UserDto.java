package com.library.kodillalibrary.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor

public class UserDto {
    private Long userId;
    private String firstName;
    private String secondName;
    private LocalDate accountCreated;
/*
    public UserDto(Long userId, String firstName, String secondName, int year,
                   int month, int day) {
        this.userId = userId;
        this.firstName = firstName;
        this.secondName = secondName;
        this.accountCreated = LocalDate.of(year, month, day);
    }

    public Long getUserId() {
        return userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public LocalDate getAccountCreated() {
        return accountCreated;
    }

 */
}
