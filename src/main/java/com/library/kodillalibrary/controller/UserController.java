package com.library.kodillalibrary.controller;

import com.library.kodillalibrary.domain.UserDto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/user")
public class UserController {

    @RequestMapping(method = RequestMethod.GET, value = "getUsers")
    public List<UserDto> getUsers() {
        return new ArrayList<>();
    }

    @RequestMapping(method = RequestMethod.GET, value = "getUser")
    public UserDto getUser (Long userId) {
        return new UserDto(1L, "John", "Rambo", LocalDate.of(2020, 2, 3));
    }

    @RequestMapping(method = RequestMethod.POST, value = "createUser")
    public void createUser(UserDto userDto) {

    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteUser")
    public void deleteUser(Long userId) {

    }
}
