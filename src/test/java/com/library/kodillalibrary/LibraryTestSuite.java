package com.library.kodillalibrary;

import com.library.kodillalibrary.dao.BookCopiesDao;
import com.library.kodillalibrary.dao.BookTitleDao;
import com.library.kodillalibrary.dao.BooksLoansDao;
import com.library.kodillalibrary.dao.UserDao;
import com.library.kodillalibrary.domain.TitleCopy;
import com.library.kodillalibrary.domain.Loan;
import com.library.kodillalibrary.domain.Title;
import com.library.kodillalibrary.domain.LibraryUser;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.ArrayList;
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
        Title title = new Title(1,"Title", "Author", 2009, new ArrayList<>());
        TitleCopy titleCopy = new TitleCopy(1,title, "in circulation", new ArrayList<>());
        TitleCopy titleCopy2 = new TitleCopy(2,title, "demaged", new ArrayList<>());
        title.getTitleCopies().add(titleCopy);
        title.getTitleCopies().add(titleCopy2);

        //When
        bookTitleDao.save(title);
        int id = title.getTitleId();

        //Then
        Assert.assertNotEquals(0, id);

        //CleanUp
        bookTitleDao.deleteById(id);

    }


    @Test
    public void testUserDaoSave() {
        //Given
        LibraryUser libraryUser = new LibraryUser(1,"Antoni", "Piechniczek", LocalDate.of(2020, 01, 21), new ArrayList<>());

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
        Title title = new Title(1,"Title", "Author", 2009, new ArrayList<>());
        TitleCopy titleCopy = new TitleCopy(1,title, "in circulation", new ArrayList<>());
        TitleCopy titleCopy2 = new TitleCopy(2,title, "demaged", new ArrayList<>());
        title.getTitleCopies().add(titleCopy);
        title.getTitleCopies().add(titleCopy2);
        LibraryUser libraryUser = new LibraryUser(1,"Antoni", "Piechniczek", LocalDate.of(2020, 01, 21), new ArrayList<>());
        Loan loan = new Loan(1, titleCopy, libraryUser, LocalDate.of(2020, 01, 21), LocalDate.of(2020, 02, 01));
        titleCopy.getCopyLoans().add(loan);
        libraryUser.getUserLoans().add(loan);

        //When
        booksLoansDao.save(loan);
        int id = loan.getLoanId();

        //Then
        Assert.assertNotEquals(0, id);

        //CleanUp
        booksLoansDao.deleteById(id);

    }
}
