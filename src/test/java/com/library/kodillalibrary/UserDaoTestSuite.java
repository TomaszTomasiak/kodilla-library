package com.library.kodillalibrary;

import com.library.kodillalibrary.dao.UserDao;
import com.library.kodillalibrary.domain.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDaoTestSuite {
    @Autowired
    private UserDao userDao;

    @Test
    public void testUserDaoSave() {
        //Given
        User user = new User("Antoni", "Piechniczek");

        //When
        userDao.save(user);

        //Then
        int id = user.getUserId();
        Optional<User> readUser = userDao.findById(id);
        Assert.assertTrue(readUser.isPresent());

        //CleanUp
        userDao.deleteById(id);
    }

}
