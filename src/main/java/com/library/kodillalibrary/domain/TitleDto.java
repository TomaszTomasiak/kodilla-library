package com.library.kodillalibrary.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TitleDto {
    private int titleId;
    private  String titleName;
    private String author;
    private int yearOfPublication;
    private List<TitleCopy> titleCopies;
}
