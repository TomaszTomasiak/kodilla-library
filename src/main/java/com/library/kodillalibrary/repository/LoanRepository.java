package com.library.kodillalibrary.repository;

import com.library.kodillalibrary.domain.BookLoan;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LoanRepository extends CrudRepository<BookLoan, Integer> {

    @Override
    List<BookLoan> findAll();
}
