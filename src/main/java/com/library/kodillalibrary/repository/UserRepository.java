package com.library.kodillalibrary.repository;

import com.library.kodillalibrary.domain.LibraryUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<LibraryUser, Integer> {

    @Override
    List<LibraryUser> findAll();

    @Override
    LibraryUser save(LibraryUser libraryUser);

    @Override
    Optional<LibraryUser> findById(Integer id);

    @Override
    void deleteById(Integer id);


}
