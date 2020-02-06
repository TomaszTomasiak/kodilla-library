package com.library.kodillalibrary.service;

import com.library.kodillalibrary.domain.BookCopy;
import com.library.kodillalibrary.domain.BookLoan;
import com.library.kodillalibrary.domain.BookTitle;
import com.library.kodillalibrary.domain.LibraryUser;
import com.library.kodillalibrary.repository.CopyRepository;
import com.library.kodillalibrary.repository.LoanRepository;
import com.library.kodillalibrary.repository.TitleRepository;
import com.library.kodillalibrary.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DbService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CopyRepository copyRepository;

    @Autowired
    private LoanRepository loanRepository;

    @Autowired
    private TitleRepository titleRepository;

    public List<LibraryUser> getAllUsers() {
        return userRepository.findAll();
    }

    public LibraryUser getLibraryUser(final int id) {
        return userRepository.findById(id).orElse(null);
    }

    public LibraryUser saveUser(final LibraryUser libraryUser) {
        return userRepository.save(libraryUser);
    }

    public void deleteUser(final int id) {
        userRepository.deleteById(id);
    }

    public List<BookCopy> getAllCopies() {
        return copyRepository.findAll();
    }

    public List<BookTitle> getAllTitles() {
        return titleRepository.findAll();
    }

    public List<BookLoan> getAllLoans() {
        return loanRepository.findAll();
    }
}
