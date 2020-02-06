package com.library.kodillalibrary.controller;


import com.library.kodillalibrary.domain.BookTitleDto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/library")
public class TitleController {
    @RequestMapping(method = RequestMethod.GET, value = "getTitles")
    public List<BookTitleDto> getTitles() {
        return new ArrayList<>();
    }

    @RequestMapping(method = RequestMethod.GET, value = "getTitle")
    public BookTitleDto getTitle (int titleId) {
        return new BookTitleDto(1,"Mock", "Krajewski", 2003);
    }

    @RequestMapping(method = RequestMethod.POST, value = "createTitle")
    public void createTitle(BookTitleDto bookTitleDto) {
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteTitle")
    public void deleteTitle(int titleId) {
    }

}
