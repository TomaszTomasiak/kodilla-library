package com.library.kodillalibrary.controller;

import com.library.kodillalibrary.domain.LoanDto;
import com.library.kodillalibrary.mapper.LoanMapper;
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
public class LoanController {

    @Autowired
    private DbService service;

    @Autowired
    private LoanMapper loanMapper;

    @RequestMapping(method = RequestMethod.GET, value = "getLoans")
    public List<LoanDto> getLoans() {
        return loanMapper.mapToLoanDtoList(service.getAllLoans());
    }

    @RequestMapping(method = RequestMethod.POST, value = "addLoan", consumes = APPLICATION_JSON_VALUE)
    public void addLoan(@RequestBody LoanDto loanDto) {
        service.addLoan(loanMapper.mapToLoan(loanDto));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteLoan")
    public void deleteLoan(int loanId) {
        service.deleteLoan(loanId);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "bookReturn")
    public LoanDto statusChange(@RequestBody LoanDto loanDto) {
        return loanMapper.mapToLoanDto(service.addLoan(loanMapper.mapToLoan(loanDto)));
    }

    @RequestMapping(method = RequestMethod.GET, value = "getUserLoans")
    public List<LoanDto> getUserLoans(int userId) {
        return loanMapper.mapToLoanDtoList(service.getUserLoans(userId));
    }

    @RequestMapping(method = RequestMethod.GET, value = "getTitleLoans")
    public List<LoanDto> getTitleLoans(int titleId) {
        return loanMapper.mapToLoanDtoList(service.getTitleLoans(titleId));
    }

    @RequestMapping(method = RequestMethod.GET, value = "getCopyLoans")
    public List<LoanDto> getCopyLoans(int copyId) {
        return loanMapper.mapToLoanDtoList(service.getCopyLoans(copyId));
    }
}

