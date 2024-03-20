package com.example.Hibernatedemo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Hibernatedemo.model.Person;

public interface PersonRepositoryInterf extends JpaRepository<Person, Integer>{
	
	List<Person> findByfirstName(String firstName);

}
