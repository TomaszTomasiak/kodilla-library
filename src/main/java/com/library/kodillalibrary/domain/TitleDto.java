package com.library.kodillalibrary.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class TitleDto {
    private int titleId;
    private String titleName;
    private String author;
    private int yearOfPublication;
    @JsonIgnore
    private List<TitleCopy> titleCopies;
}
