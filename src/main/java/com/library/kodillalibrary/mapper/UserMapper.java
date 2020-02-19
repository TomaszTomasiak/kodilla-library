package com.library.kodillalibrary.mapper;

import com.library.kodillalibrary.domain.LibraryUser;
import com.library.kodillalibrary.domain.LibraryUserDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {
    public LibraryUser mapToLibraryUser(final LibraryUserDto libraryUserDto) {
        return new LibraryUser(
                libraryUserDto.getUserId(),
                libraryUserDto.getFirstName(),
                libraryUserDto.getLastName(),
                libraryUserDto.getAccountCreated(),
                libraryUserDto.getUserLoans());
    }

    public LibraryUserDto mapToLibraryUserDto(final LibraryUser libraryUser) {
        return new LibraryUserDto(
                libraryUser.getUserId(),
                libraryUser.getFirstName(),
                libraryUser.getLastName(),
                libraryUser.getAccountCreated(),
                libraryUser.getUserLoans());
    }

    public List<LibraryUserDto> mapToLibraryUserDtoList(final List<LibraryUser> userList) {
        return userList.stream()
                .map(u -> new LibraryUserDto(u.getUserId(), u.getFirstName(), u.getLastName(), u.getAccountCreated(), u.getUserLoans()))
                .collect(Collectors.toList());
    }
}
