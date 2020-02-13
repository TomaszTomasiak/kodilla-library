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

/*
    public Loan(int loanId, Copy copy, LibraryUser libraryUser, LocalDate loanedDate, LocalDate returnedDate) {
        this.loanId = loanId;
        this.copy = copy;
        this.libraryUser = libraryUser;
        this.loanedDate = loanedDate;
        this.returnedDate = returnedDate;
    }

    public Loan(Copy copy, LibraryUser libraryUser, LocalDate loanedDate, LocalDate returnedDate) {
        this.copy = copy;
        this.libraryUser = libraryUser;
        this.loanedDate = loanedDate;
        this.returnedDate = returnedDate;
    }
    public Loan() {
    }



    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "LOAN_ID", unique = true)
    public int getLoanId() {
        return loanId;
    }



    @ManyToOne
    @JoinColumn(name = "COPY_ID")
    public Copy getCopy() {
        return copy;
    }

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    public LibraryUser getLibraryUser() {
        return libraryUser;
    }

    @Column(name = "LOANED")
    public LocalDate getLoanedDate() {
        return loanedDate;
    }

    @Column(name = "RETURNED")
    public LocalDate getReturnedDate() {
        return returnedDate;
    }

    public void setLoanId(int loanId) {
        this.loanId = loanId;
    }
    public void setReturnedDate(LocalDate returnedDate) {
        this.returnedDate = returnedDate;
    }

    public void setCopy(Copy copy) {
        this.copy = copy;
    }

    public void setLibraryUser(LibraryUser libraryUser) {
        this.libraryUser = libraryUser;
    }

    public void setLoanedDate(LocalDate loanedDate) {
        this.loanedDate = loanedDate;
    }

 */
}
