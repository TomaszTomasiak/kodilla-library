package com.library.kodillalibrary.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "LOANS")
public class BookLoan {

    private int loanId;
    private BookCopy bookCopy;
    private LibraryUser libraryUser;
    private LocalDate loanedDate;
    private LocalDate returnedDate;

    public BookLoan( LocalDate loanedDate, LocalDate returnedDate) {
        //this.bookCopy = bookCopy;
        //this.libraryUser = libraryUser;
        this.loanedDate = loanedDate;
        this.returnedDate = returnedDate;
    }

    public BookLoan() {
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
    public BookCopy getBookCopy() {
        return bookCopy;
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

    public void setBookCopy(BookCopy bookCopy) {
        this.bookCopy = bookCopy;
    }

    public void setLibraryUser(LibraryUser libraryUser) {
        this.libraryUser = libraryUser;
    }

    public void setLoanedDate(LocalDate loanedDate) {
        this.loanedDate = loanedDate;
    }
}
