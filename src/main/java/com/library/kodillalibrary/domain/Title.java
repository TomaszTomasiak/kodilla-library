package com.library.kodillalibrary.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
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

    @JsonIgnore
    @OneToMany(
            targetEntity = TitleCopy.class,
            mappedBy = "title",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<TitleCopy> titleCopies = new ArrayList<>();

}

