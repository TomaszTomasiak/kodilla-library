package com.library.kodillalibrary.repository;

import com.library.kodillalibrary.domain.TitleCopy;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TitleCopyRepository extends CrudRepository<TitleCopy, Integer> {

    @Override
    List<TitleCopy> findAll();

    @Override
    TitleCopy save(TitleCopy titleCopy);

    @Override
    Optional<TitleCopy> findById(Integer copyId);

    @Override
    void deleteById(Integer copyId);

    TitleCopy findByCopyId(Integer copyId);
}

