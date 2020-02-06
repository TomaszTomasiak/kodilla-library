package com.library.kodillalibrary.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "TITLES")
public class BookTitle {

    private int titleId;
    private  String titleName;
    private String author;
    private int yearOfPublication;
    private List<BookCopy> copies = new ArrayList<>();

    public BookTitle() {
    }

    public BookTitle(String titleName, String author, int yearOfPublication) {
        this.titleName = titleName;
        this.author = author;
        this.yearOfPublication = yearOfPublication;
    }
    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ID", unique = true)
    public int getTitleId() {
        return titleId;
    }

    public void setTitleId(int titleId) {
        this.titleId = titleId;
    }

    @Column(name = "TITLE")
    public String getTitleName() {
        return titleName;
    }

    public void setTitleName(String titleName) {
        this.titleName = titleName;
    }

    @Column(name = "AUTHOR")
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Column(name = "PUBLICATED")
    public int getYearOfPublication() {
        return yearOfPublication;
    }

    public void setYearOfPublication(int yearOfPublication) {
        this.yearOfPublication = yearOfPublication;
    }

    @OneToMany(
            targetEntity = BookCopy.class,
            mappedBy = "bookTitle",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    public List<BookCopy> getCopies() {
        return copies;
    }

    public void setCopies(List<BookCopy> copies) {
        this.copies = copies;
    }
}

