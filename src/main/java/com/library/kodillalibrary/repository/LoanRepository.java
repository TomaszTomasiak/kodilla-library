package com.library.kodillalibrary.repository;

import com.library.kodillalibrary.domain.Loan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoanRepository extends CrudRepository<Loan, Integer> {

    @Override
    List<Loan> findAll();

    @Override
    Loan save(Loan loan);

    @Override
    void deleteById(Integer loanId);
}
