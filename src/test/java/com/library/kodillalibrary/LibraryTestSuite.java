package com.library.kodillalibrary;

import com.library.kodillalibrary.dao.BookCopiesDao;
import com.library.kodillalibrary.dao.BookTitleDao;
import com.library.kodillalibrary.dao.BooksLoansDao;
import com.library.kodillalibrary.dao.UserDao;
import com.library.kodillalibrary.domain.BookCopy;
import com.library.kodillalibrary.domain.BookLoan;
import com.library.kodillalibrary.domain.BookTitle;
import com.library.kodillalibrary.domain.LibraryUser;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LibraryTestSuite {
    @Autowired
    private UserDao userDao;

    @Autowired
    private BookCopiesDao bookCopiesDao;

    @Autowired
    private BooksLoansDao booksLoansDao;

    @Autowired
    private BookTitleDao bookTitleDao;


    @Test
    public void testBookTitleDaoSaveWithCopies() {
        //Given
        BookTitle bookTitle = new BookTitle("Title", "Author", 2009);
        BookCopy bookCopy = new BookCopy(bookTitle, "in circulation");
        BookCopy bookCopy2 = new BookCopy(bookTitle, "demaged");
        bookTitle.getCopies().add(bookCopy);
        bookTitle.getCopies().add(bookCopy2);

        //When
        bookTitleDao.save(bookTitle);
        int id = bookTitle.getTitleId();

        //Then
        Assert.assertNotEquals(0, id);

        //CleanUp
        bookTitleDao.deleteById(id);

    }


    @Test
    public void testUserDaoSave() {
        //Given
        LibraryUser libraryUser = new LibraryUser("Antoni", "Piechniczek");

        //When
        userDao.save(libraryUser);

        //Then
        int id = libraryUser.getUserId();
        Optional<LibraryUser> readUser = userDao.findById(id);
        Assert.assertTrue(readUser.isPresent());

        //CleanUp
        userDao.deleteById(id);
    }

    @Test
    public void testBookLoansDaoSaveWithCopiesAndUsers() {
        //Given
        BookTitle bookTitle = new BookTitle("Title", "Author", 2009);
        BookCopy bookCopy = new BookCopy(bookTitle, "in circulation");
        BookCopy bookCopy2 = new BookCopy(bookTitle, "demaged");
        bookTitle.getCopies().add(bookCopy);
        bookTitle.getCopies().add(bookCopy2);
        LibraryUser libraryUser = new LibraryUser("Hrabia", "Dracula");
        BookLoan bookLoan = new BookLoan(LocalDate.of(2020, 01, 21), LocalDate.of(2020, 02, 01));
        bookCopy.getLoans().add(bookLoan);
        libraryUser.getLoans().add(bookLoan);

        //When
        booksLoansDao.save(bookLoan);
        int id = bookLoan.getLoanId();

        //Then
        Assert.assertNotEquals(0, id);

        //CleanUp
        booksLoansDao.deleteById(id);

    }
}
