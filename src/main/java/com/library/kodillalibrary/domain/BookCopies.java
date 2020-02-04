package com.library.kodillalibrary.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "COPIES")
public class BookCopies {

    private int copieId;
    private int titleId;
    private String status;

    public BookCopies(int titleId, String status) {
        this.titleId = titleId;
        this.status = status;
    }

    public BookCopies() {
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

    @Column(name = "STATUS")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
