package com.javatechie.spring.mockito.api;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.javatechie.spring.mockito.api.dao.UserRepository;
import com.javatechie.spring.mockito.api.model.User;
import com.javatechie.spring.mockito.api.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootMockitoApplicationTests {

	@Autowired
	private UserService service;

	@MockBean
	private UserRepository repository;

	@Test
	public void getUsersTest() {
		//БД нет, поэтому нужно подменить findAll чтобы протестировать getUsers
		when(repository.findAll()).thenReturn(
				Stream.of(new User(167, "Jim", 11), 
						  new User(341, "Lilly", 25))
					  .collect(Collectors.toList()));
		assertEquals(2, service.getUsers().size());
	}

	@Test
	public void getUserbyNameTest() {
		//БД нет, поэтому нужно подменить findByName("Mike") чтобы протестировать getUserByName("Mike")
		when(repository.findByName("Mike"))
				.thenReturn(
						Stream.of(new User(333, "Mike", 21))
						.collect(Collectors.toList()));
		assertEquals(1, service.getUserByName("Mike").size());
	}

	@Test
	public void addUserTest() {
		//БД нет, поэтому нужно подменить save(user) чтобы протестировать addUser(user)
		User user = new User(478, "Mike", 41);
		when(repository.save(user)).thenReturn(user);
		assertEquals(user, service.addUser(user));
	}

}
