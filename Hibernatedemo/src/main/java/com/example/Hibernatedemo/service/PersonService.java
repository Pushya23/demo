package com.example.Hibernatedemo.service;

import java.util.List;

import com.example.Hibernatedemo.dto.Persondto;
import com.example.Hibernatedemo.model.Person;


public interface PersonService {
	
	Person createPersonStatic(Persondto persondto);
	Person getPerson(int id);
	Person deletPerson(int id);
	List<Person> getAllPersons();

}
