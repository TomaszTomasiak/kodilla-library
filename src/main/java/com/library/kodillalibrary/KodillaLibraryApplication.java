package com.library.kodillalibrary;

import com.library.kodillalibrary.domain.UserDto;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class KodillaLibraryApplication {

	public static void main(String[] args) {
		//SpringApplication.run(KodillaLibraryApplication.class, args);

		UserDto userDto = new UserDto((long)1, "uuu" ,"iii", LocalDate.of(2020, 2, 2));
		Long id = userDto.getUserId();
		String name = userDto.getFirstName();
		String surname = userDto.getSecondName();
		LocalDate date = userDto.getAccountCreated();

		System.out.println(id + " " + name + " " + surname + " " + date);
	}

}
