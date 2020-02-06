package com.library.kodillalibrary.controller;


import com.library.kodillalibrary.domain.BookCopy;
import com.library.kodillalibrary.domain.BookLoanDto;
import com.library.kodillalibrary.domain.BookTitle;
import com.library.kodillalibrary.domain.LibraryUser;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/library")
public class LoanController {
    @RequestMapping(method = RequestMethod.GET, value = "getLoans")
    public List<BookLoanDto> getLoans() {
        return new ArrayList<>();
    }

    @RequestMapping(method = RequestMethod.GET, value = "getLoan")
    public BookLoanDto getLoan (int loanId) {
        BookTitle bookTitle = new BookTitle("Title", "Author", 2009);
        BookCopy bookCopy = new BookCopy(bookTitle, "in circulation");
        LibraryUser libraryUser = new LibraryUser("Hrabia", "Dracula");
        return new BookLoanDto(1,bookCopy, libraryUser, LocalDate.of(2020,01, 21), LocalDate.of(2020,01, 28)); //wróć do konstruktora
    }

    @RequestMapping(method = RequestMethod.POST, value = "createLoan")
    public void createLoan(BookLoanDto bookLoaDto) { //wróć do konstruktora
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteLoan")
    public void deleteLoan(int loanId) {
    }
}
