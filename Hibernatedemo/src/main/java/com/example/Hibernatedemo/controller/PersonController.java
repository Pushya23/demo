package com.example.Hibernatedemo.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Hibernatedemo.dto.Persondto;
import com.example.Hibernatedemo.model.Person;
import com.example.Hibernatedemo.service.PersonService;


@RestController
public class PersonController {
	
	@Autowired
	PersonService personService;
	
	private static Logger logger = LoggerFactory.getLogger(PersonController.class);
	
	@PostMapping("/person")
	public ResponseEntity createPerson(@RequestBody @Valid Persondto persondto ) {
//		Person person = new Person();
//		person.setAge(0);
//		person.setDoB(null);
//		
//		person.builder().age(12).firstName(null).build();
		
		logger.info(persondto.toString());
		Person person = personService.createPersonStatic(persondto);
		return new ResponseEntity(person, HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/person/{personId}")
	public Person getPerson(@PathVariable int personId) {
		return personService.getPerson(personId);
	}
	
	@GetMapping("/persons")
	public List<Person> getAllPersons(){
		return personService.getAllPersons();
	}
	
	@DeleteMapping("/person/{personId}")
	public void deletePerson(@PathVariable int personId) {
		personService.deletPerson(personId);
	}

}
