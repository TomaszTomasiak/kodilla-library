package com.library.kodillalibrary.repository;

import com.library.kodillalibrary.domain.BookTitle;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TitleRepository extends CrudRepository<BookTitle, Integer> {

    @Override
    List<BookTitle> findAll();
}
