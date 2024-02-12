package com.javatechie.spring.mockito.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.javatechie.spring.mockito.api.model.User;
import com.javatechie.spring.mockito.api.service.UserService;

@RestController
@SpringBootApplication
public class SpringBootMockitoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMockitoApplication.class, args);
	}
	@Autowired
	private UserService service;

	@PostMapping(value = "/save")
	public User saveUser(@RequestBody User user) {
		return service.addUser(user);
	}
	@GetMapping("/getUsers")
	public List<User> findAllUsers() {
		return service.getUsers();
	}
	@GetMapping("/getUserByName/{name}")
	public List<User> findUserByName(@PathVariable String name) {
		return service.getUserByName(name);
	}
}
