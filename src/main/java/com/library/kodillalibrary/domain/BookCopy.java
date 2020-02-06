package com.library.kodillalibrary.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "COPIES")
public class BookCopy {

    private int copieId;
    private BookTitle bookTitle;
    private String status;
    private List<BookLoan> loans = new ArrayList<>();

    public BookCopy(BookTitle bookTitle, String status) {
        this.bookTitle = bookTitle;
        this.status = status;
    }

    public BookCopy() {
    }

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "COPY_ID", unique = true)
    public int getCopieId() {
        return copieId;
    }

    @OneToMany(
            targetEntity = BookLoan.class,
            mappedBy = "bookCopy",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    public List<BookLoan> getLoans() {
        return loans;
    }

    @Column(name = "STATUS")
    public String getStatus() {
        return status;
    }

    @ManyToOne
    @JoinColumn(name = "TITLE_ID")
    public BookTitle getBookTitle() {
        return bookTitle;
    }

    public void setCopieId(int copieId) {
        this.copieId = copieId;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setBookTitle(BookTitle bookTitle) {
        this.bookTitle = bookTitle;
    }

    public void setLoans(List<BookLoan> loans) {
        this.loans = loans;
    }
}
