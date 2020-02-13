package com.library.kodillalibrary.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
//@AllArgsConstructor
//@NoArgsConstructor
@Entity
@Table(name = "TITLES")
public class Title {

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ID", unique = true)
    private int titleId;

    @Column(name = "TITLE")
    private  String titleName;

    @Column(name = "AUTHOR")
    private String author;

    @Column(name = "PUBLICATED")
    private int yearOfPublication;

    @OneToMany(
            targetEntity = TitleCopy.class,
            mappedBy = "title",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<TitleCopy> titleCopies = new ArrayList<>();

    @Autowired
    public Title(int titleId, String titleName, String author, int yearOfPublication, List<TitleCopy> titleCopies) {
        this.titleId = titleId;
        this.titleName = titleName;
        this.author = author;
        this.yearOfPublication = yearOfPublication;
        this.titleCopies = titleCopies;
    }

    public Title() {
    }

    public Title(int titleId) {
        this.titleId = titleId;
    }

}

