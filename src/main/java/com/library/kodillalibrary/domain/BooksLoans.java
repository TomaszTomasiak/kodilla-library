package com.library.kodillalibrary.domain;

import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "LOANS")
public class BooksLoans {

    private int copieId;
    private int titleId;
    private Date loanedDate;
    private Date returnedDate;

    public BooksLoans(int titleId, Date loanedDate, Date returnedDate) {
        this.titleId = titleId;
        this.loanedDate = loanedDate;
        this.returnedDate = returnedDate;
    }

    public BooksLoans() {
    }

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ID", unique = true)
    public int getCopieId() {
        return copieId;
    }

    public void setCopieId(int copieId) {
        this.copieId = copieId;
    }
    @Column(name = "TITLE_ID")
    public int getTitleId() {
        return titleId;
    }

    public void setTitleId(int titleId) {
        this.titleId = titleId;
    }

    @Column(name = "LOANED")
    public Date getLoanedDate() {
        return loanedDate;
    }

    public void setLoanedDate(Date loanedDate) {
        this.loanedDate = loanedDate;
    }

    @Column(name = "RETURNED")
    public Date getReturnedDate() {
        return returnedDate;
    }

    public void setReturnedDate(Date returnedDate) {
        this.returnedDate = returnedDate;
    }
}
