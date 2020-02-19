package com.library.kodillalibrary.dao;

import com.library.kodillalibrary.domain.LibraryUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface UserDao extends CrudRepository<LibraryUser, Integer> {
}
