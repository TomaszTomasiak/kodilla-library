package com.library.kodillalibrary.service;

import com.library.kodillalibrary.domain.TitleCopy;
import com.library.kodillalibrary.domain.Loan;
import com.library.kodillalibrary.domain.Title;
import com.library.kodillalibrary.domain.LibraryUser;
import com.library.kodillalibrary.repository.TitleCopyRepository;
import com.library.kodillalibrary.repository.LoanRepository;
import com.library.kodillalibrary.repository.TitleRepository;
import com.library.kodillalibrary.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Transactional
@Service
public class DbService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TitleCopyRepository titleCopyRepository;

    @Autowired
    private LoanRepository loanRepository;

    @Autowired
    private TitleRepository titleRepository;

    public List<LibraryUser> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<LibraryUser> getUser(final int id) {
        return userRepository.findById(id);
    }

    public LibraryUser addUser(final LibraryUser libraryUser) {
        return userRepository.save(libraryUser);
    }

    public void deleteUser(final int id) {
        userRepository.deleteById(id);
    }

    public List<TitleCopy> getAllCopies() {
        return titleCopyRepository.findAll();
    }

    public List<TitleCopy> getAllAvailableCopiesOfTitle(final int titleId) {

        List<TitleCopy> availableCopiesList = titleCopyRepository.findAll().stream()
                .filter(n -> n.getTitle().getTitleId() == titleId)
                .filter(c -> c.getStatus().equals("in circulation"))
                .collect(Collectors.toList());

        List<Loan> unreturnedLoansContainsTheCopy = loanRepository.findAll().stream()
                .filter(c -> c.getReturnedDate() == null)
                .filter(c -> c.getTitleCopy().getTitle().getTitleId() == titleId)
                .collect(Collectors.toList());

        for (int i = 0; i < availableCopiesList.size(); i++) {
            for (int n = 0; n < unreturnedLoansContainsTheCopy.size(); n++) {
                if (unreturnedLoansContainsTheCopy.get(n).getTitleCopy().getCopyId() == availableCopiesList.get(i).getCopyId()) {
                    availableCopiesList.remove(availableCopiesList.get(i));
                }
            }
        }
        return availableCopiesList;
    }

    public Optional<TitleCopy> getCopy(final int copyId) {
        return titleCopyRepository.findById(copyId);
    }

    public TitleCopy addCopy(final TitleCopy titleCopy) {
        return titleCopyRepository.save(titleCopy);
    }

    public void deleteCopy(final int copyId) {
        titleCopyRepository.deleteById(copyId);
    }

    public List<Title> getAllTitles() {
        return titleRepository.findAll();
    }

    public Title addTitle(final Title title) {
        return titleRepository.save(title);
    }

    public Optional<Title> getTitle(final int titleId) {
        return titleRepository.findById(titleId);
    }

    public void deleteTitle(final int titleId) {
        titleRepository.deleteById(titleId);
    }

    public List<Loan> getAllLoans() {
        return loanRepository.findAll();
    }

    public Loan addLoan(final Loan loan) {
        return loanRepository.save(loan);
    }

    public void deleteLoan(final int loanId) {
        loanRepository.deleteById(loanId);
    }

    public List<Loan> getTitleLoans(final int titleId) {
        return loanRepository.findAll().stream()
                .filter(l -> l.getTitleCopy().getTitle().getTitleId() == titleId)
                .collect(Collectors.toList());
    }

    public List<Loan> getUserLoans(final int userId) {
        return loanRepository.findAll().stream()
                .filter(l -> l.getLibraryUser().getUserId() == userId)
                .collect(Collectors.toList());
    }

    public List<Loan> getCopyLoans(final int copyId) {
        return loanRepository.findAll().stream()
                .filter(l -> l.getTitleCopy().getCopyId() == copyId)
                .collect(Collectors.toList());
    }

    public List<TitleCopy> availableCopiesFromTitle(final int titleId) {
        return titleCopyRepository.findAll().stream()
                .filter(t -> t.getTitle().getTitleId() == titleId)
                .filter(c -> c.getStatus().equals("in circulation"))
                .collect(Collectors.toList());
    }
}
