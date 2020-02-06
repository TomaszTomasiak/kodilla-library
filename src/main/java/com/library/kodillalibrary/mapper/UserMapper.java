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
                libraryUserDto.getSecondName(),
                libraryUserDto.getAccountCreated(),
                libraryUserDto.getLoans());
    }

    public LibraryUserDto mapToLibraryUserDto (final LibraryUser libraryUser) {
        return new LibraryUserDto(
                libraryUser.getUserId(),
                libraryUser.getFirstName(),
                libraryUser.getSecondName(),
                libraryUser.getAccountCreated(),
                libraryUser.getLoans());
    }

    public List<LibraryUserDto> mapToLibraryUserDtoList(final List<LibraryUser> userList) {
        return userList.stream()
                .map(u -> new LibraryUserDto(u.getUserId(), u.getFirstName(), u.getSecondName(), u.getAccountCreated(), u.getLoans()))
                .collect(Collectors.toList());
    }
}
