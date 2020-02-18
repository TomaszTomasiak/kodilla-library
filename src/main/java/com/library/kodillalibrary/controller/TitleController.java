package com.library.kodillalibrary.controller;


import com.library.kodillalibrary.domain.TitleCopyDto;
import com.library.kodillalibrary.domain.TitleDto;
import com.library.kodillalibrary.mapper.TitleMapper;
import com.library.kodillalibrary.service.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/v1/library")
public class TitleController {

    @Autowired
    private DbService service;

    @Autowired
    private TitleMapper titleMapper;

    @RequestMapping(method = RequestMethod.GET, value = "getTitles")
    public List<TitleDto> getTitles() {
        return titleMapper.mapToTitleDtoList(service.getAllTitles());
    }

    @RequestMapping(method = RequestMethod.GET, value = "getTitle")
    public TitleDto getTitle(int titleId) throws ThisThingNotFoundException {
        return titleMapper.mapToTitleDto(service.getTitle(titleId).orElseThrow(ThisThingNotFoundException::new));
    }

    @RequestMapping(method = RequestMethod.POST, value = "addTitle", consumes = APPLICATION_JSON_VALUE)
    public void addTitle(@RequestBody TitleDto titleDto) {
        service.addTitle(titleMapper.mapToTitle(titleDto));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteTitle")
    public void deleteTitle(int titleId) {
        service.deleteTitle(titleId);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "updateTitle")
    public TitleDto updateTitle(@RequestBody TitleDto titleDto) {
        return titleMapper.mapToTitleDto(service.addTitle(titleMapper.mapToTitle(titleDto)));
    }

}
