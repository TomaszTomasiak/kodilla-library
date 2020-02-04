package com.library.kodillalibrary.dao;

import com.library.kodillalibrary.domain.BookTitle;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface BookTitleDao extends CrudRepository<BookTitle, Integer> {
}
