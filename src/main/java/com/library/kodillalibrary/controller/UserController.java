package com.library.kodillalibrary.controller;

import com.library.kodillalibrary.domain.LibraryUserDto;
import com.library.kodillalibrary.mapper.UserMapper;
import com.library.kodillalibrary.service.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/v1/library")
public class UserController {
    @Autowired
    private DbService service;
    @Autowired
    private UserMapper userMapper;

    @RequestMapping(method = RequestMethod.GET, value = "getUsers")
    public List<LibraryUserDto> getUsers() {
        return userMapper.mapToLibraryUserDtoList(service.getAllUsers());
    }

    @RequestMapping(method = RequestMethod.GET, value = "getUser")
    public LibraryUserDto getUser(int userId) throws ThisThingNotFoundException {
        return userMapper.mapToLibraryUserDto(service.getUser(userId).orElseThrow(ThisThingNotFoundException::new));
    }

    @RequestMapping(method = RequestMethod.POST, value = "addUser", consumes = APPLICATION_JSON_VALUE)
    public void addUser(@RequestBody LibraryUserDto libraryUserDto) {
        service.addUser(userMapper.mapToLibraryUser(libraryUserDto));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteUser")
    public void deleteUser(int userId) {
        service.deleteUser(userId);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "updateUser")
    public LibraryUserDto updateUser(@RequestBody LibraryUserDto libraryUserDto) {
        return userMapper.mapToLibraryUserDto(service.addUser(userMapper.mapToLibraryUser(libraryUserDto)));
    }
}
