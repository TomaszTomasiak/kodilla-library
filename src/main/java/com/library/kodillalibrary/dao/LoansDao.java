package com.library.kodillalibrary.dao;

import com.library.kodillalibrary.domain.Loan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface LoansDao extends CrudRepository<Loan, Integer> {
}
