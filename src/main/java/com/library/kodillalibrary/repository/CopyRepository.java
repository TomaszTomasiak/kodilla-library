package com.library.kodillalibrary.repository;

import com.library.kodillalibrary.domain.BookCopy;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CopyRepository extends CrudRepository<BookCopy, Integer> {

    @Override
    List<BookCopy> findAll();
}
