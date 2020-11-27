package com.library.kodillalibrary.mapper;

import com.library.kodillalibrary.domain.Loan;
import com.library.kodillalibrary.domain.LoanDto;
import com.library.kodillalibrary.repository.TitleCopyRepository;
import com.library.kodillalibrary.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class LoanMapper {
    @Autowired
    TitleCopyRepository titleCopyRepository;

    @Autowired
    UserRepository userRepository;

    public Loan mapToLoan(final LoanDto loanDto) {
        return new Loan(
                loanDto.getLoanId(),
                titleCopyRepository.findById(loanDto.getCopyId()).orElse(null),
                userRepository.findByUserId(loanDto.getUserId()),
                loanDto.getLoanedDate(),
                loanDto.getReturnedDate());
    }

    public LoanDto mapToLoanDto(final Loan loan) {
        return new LoanDto(
                loan.getLoanId(),
                loan.getTitleCopy().getCopyId(),
                loan.getLibraryUser().getUserId(),
                loan.getLoanedDate(),
                loan.getReturnedDate());
    }

    public List<LoanDto> mapToLoanDtoList(final List<Loan> loanList) {
        return loanList.stream()
                .map(l -> new LoanDto(l.getLoanId(), l.getTitleCopy().getCopyId(), l.getLibraryUser().getUserId(), l.getLoanedDate(), l.getReturnedDate()))
                .collect(Collectors.toList());
    }
}
