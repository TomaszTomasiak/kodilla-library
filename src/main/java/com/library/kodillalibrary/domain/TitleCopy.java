package com.library.kodillalibrary.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "TITLE_COPIES")
public class TitleCopy {

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "TITLE_COPY_ID", unique = true)
    private int copyId;

    @ManyToOne
    @JoinColumn(name = "TITLE_ID")
    private Title title;

    @Column(name = "STATUS")
    private String status;

    @JsonIgnore
    @OneToMany(
            targetEntity = Loan.class,
            mappedBy = "titleCopy",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Loan> copyLoans = new ArrayList<>();
}
