package com.library.kodillalibrary.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "LOANS")
public class Loan {

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "LOAN_ID", unique = true)
    private int loanId;

    @ManyToOne
    @JoinColumn(name = "COPY_ID")
    private TitleCopy titleCopy;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private LibraryUser libraryUser;

    @Column(name = "LOANED")
    private LocalDate loanedDate;

    @Column(name = "RETURNED")
    private LocalDate returnedDate;

}
