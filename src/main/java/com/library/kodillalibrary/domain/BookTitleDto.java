package com.library.kodillalibrary.domain;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class BookTitleDto {
    private int titleId;
    private  String titleName;
    private String author;
    private int yearOfPublication;
    private List<BookCopy> copies = new ArrayList<>();

    public BookTitleDto(int titleId, String titleName, String author, int yearOfPublication) {
        this.titleId = titleId;
        this.titleName = titleName;
        this.author = author;
        this.yearOfPublication = yearOfPublication;
    }
}
