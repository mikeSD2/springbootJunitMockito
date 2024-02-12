package com.javatechie.spring.mockito.api.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Document(collection = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {
	public User(int id, String name, int age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}
	@Id
	private int id;
	private String name;
	private int age;

}
