package com.library.kodillalibrary.dao;

import com.library.kodillalibrary.domain.TitleCopy;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface CopiesDao extends CrudRepository<TitleCopy, Integer> {
}
