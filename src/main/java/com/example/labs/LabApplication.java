package com.example.labs;

import com.example.labs.domain.User;
import com.example.labs.repo.UserRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class LabApplication {

	@Autowired
	private UserRepo userRepo;
	public static void main(String[] args) {
		SpringApplication.run(LabApplication.class, args);
	}
	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}

	@PostConstruct
	public void initUsers() {
		List<User> users = Stream.of(
				new User(101,"javatechi@gmail.com", "techie", "pwd1", "JavaTechie", "LJavaTechie", new ArrayList<>(), new ArrayList<>()),
				new User(102, "user1@gmail.com", "user1", "pwd2", "User1", "LUser1", new ArrayList<>(), new ArrayList<>()),
				new User(103, "user2@gmail.com", "user2", "pwd3", "User2", "LUser2", new ArrayList<>(), new ArrayList<>())

		).collect(Collectors.toList());

		userRepo.saveAll(users);
	}
}
