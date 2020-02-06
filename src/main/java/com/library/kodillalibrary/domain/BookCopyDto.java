package com.library.kodillalibrary.domain;

import lombok.Getter;
import java.util.ArrayList;
import java.util.List;

@Getter
public class BookCopyDto {
    private int copieId;
    private BookTitle bookTitle;
    private String status;
    private List<BookLoan> loans = new ArrayList<>();

    // konstruktor do poprawy
    public BookCopyDto(int copieId, String status) {
        this.copieId = copieId;
        this.status = status;
    }
}
