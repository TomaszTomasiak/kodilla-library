package com.library.kodillalibrary.controller;


import com.library.kodillalibrary.domain.BookCopyDto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/library")
public class CopyController {
    @RequestMapping(method = RequestMethod.GET, value = "getCopies")
    public List<BookCopyDto> getCopies() {
        return new ArrayList<>();
    }

    @RequestMapping(method = RequestMethod.GET, value = "getCopy")
    public BookCopyDto getCopy (int copyId) {
        return new BookCopyDto(1,"in circulation"); //wróć do konstruktora
    }

    @RequestMapping(method = RequestMethod.POST, value = "createCopy")
    public void createCopy(BookCopyDto bookCopyDto) { //wróć do konstruktora
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteCopy")
    public void deleteCopy(int copyId) {
    }
}
