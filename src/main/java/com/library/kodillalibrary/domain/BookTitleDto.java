package com.library.kodillalibrary.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BookTitleDto {
    private Long titleId;
    private  String titleName;
    private String author;
    private int yearOfPublication;
}
