package com.library.kodillalibrary.mapper;

import com.library.kodillalibrary.domain.Loan;
import com.library.kodillalibrary.domain.LoanDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class LoanMapper {

    public Loan mapToBookLoan(final LoanDto loanDto) {
        return new Loan(
                loanDto.getLoanId(),
                loanDto.getTitleCopy(),
                loanDto.getLibraryUser(),
                loanDto.getLoanedDate(),
                loanDto.getReturnedDate());
    }

    public LoanDto mapToBookLoanDto(final Loan loan) {
        return new LoanDto(
                loan.getLoanId(),
                loan.getTitleCopy(),
                loan.getLibraryUser(),
                loan.getLoanedDate(),
                loan.getReturnedDate());
    }

    public List<LoanDto> mapToBookLoanDtoList(final List<Loan> loanList) {
        return loanList.stream()
                .map(l -> new LoanDto(l.getLoanId(), l.getTitleCopy(), l.getLibraryUser(), l.getLoanedDate(), l.getReturnedDate()))
                .collect(Collectors.toList());
    }
}
