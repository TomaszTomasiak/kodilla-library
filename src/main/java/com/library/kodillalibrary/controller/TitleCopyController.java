package com.library.kodillalibrary.controller;

import com.library.kodillalibrary.domain.TitleCopyDto;
import com.library.kodillalibrary.mapper.TitleCopyMapper;
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
public class TitleCopyController {

    @Autowired
    private TitleCopyMapper titleCopyMapper;

    @Autowired
    private DbService service;

    @RequestMapping(method = RequestMethod.GET, value = "getCopies")
    public List<TitleCopyDto> getCopies() {
        return titleCopyMapper.mapToBookCopyDtoList(service.getAllCopies());
    }

    @RequestMapping(method = RequestMethod.GET, value = "getCopy")
    public TitleCopyDto getCopy (int copyId) throws ThisThingNotFoundException{
        return titleCopyMapper.mapToBookCopyDto(service.getCopy(copyId).orElseThrow(ThisThingNotFoundException::new));
    }

    @RequestMapping(method = RequestMethod.POST, value = "addCopy", consumes = APPLICATION_JSON_VALUE)
    public void createCopy(@RequestBody TitleCopyDto titleCopyDto) {
        service.addCopy(titleCopyMapper.mapToBookCopy(titleCopyDto));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteCopy")
    public void deleteCopy(int copyId) {
        service.deleteCopy(copyId);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "updateCopy")
    public TitleCopyDto statusChange(@RequestBody TitleCopyDto titleCopyDto) {
        return titleCopyMapper.mapToBookCopyDto(service.addCopy(titleCopyMapper.mapToBookCopy(titleCopyDto)));
    }

    @RequestMapping(method = RequestMethod.GET, value = "getAvailableCopies")
    public List<TitleCopyDto> getAvailableCopies(int titleId){
        return titleCopyMapper.mapToBookCopyDtoList(service.getAllAvailableCopiesOfTitle(titleId));
    }
}
