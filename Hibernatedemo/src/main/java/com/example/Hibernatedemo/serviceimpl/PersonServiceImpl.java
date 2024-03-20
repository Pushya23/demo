package com.example.Hibernatedemo.serviceimpl;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Hibernatedemo.dto.Persondto;
import com.example.Hibernatedemo.exception.BadPersonRequestException;
import com.example.Hibernatedemo.model.Person;
import com.example.Hibernatedemo.repository.PersonRepositoryInterf;
import com.example.Hibernatedemo.service.PersonService;


@Service
public class PersonServiceImpl implements PersonService {
	
	@Autowired
	PersonRepositoryInterf personRepositoryInterf;

	@Override
	public Person createPersonStatic(Persondto persondto) {
		Person person = persondto.toPerson();
		if(person.getAge() == 0) {
			person.setAge(calculateAgeFromDoB(person.getDoB()));
		}
		Person person1 = personRepositoryInterf.save(person);
		return person1;
		
	}

	@Override
	public Person getPerson(int id) {
		return personRepositoryInterf.findById(id).orElseThrow(
				() -> new BadPersonRequestException("Person with ID "+id+" doesn't exist!"));
	}

	@Override
	public Person deletPerson(int id) {
		Person person = personRepositoryInterf.findById(id).orElseThrow(
		() -> new BadPersonRequestException("Person with ID "+id+" doesn't exist!"));

		personRepositoryInterf.deleteById(id);
		return person;
	}

	@Override
	public List<Person> getAllPersons() {
		return personRepositoryInterf.findByfirstName("Manish");
	}
	
//	public Person updatePerson(Persondto persondto) {
//		Person person = persondto.toPerson();
//		if(person.getAge() == 0) {
//			person.setAge(calculateAgeFromDoB(person.getDoB()));
//		}
//		Person person1 = personRepositoryInterf.save(person);
//		return person1;
//		
//	}
	
	private Integer calculateAgeFromDoB(String dob) {
		if(dob == null)
			return null;
		LocalDate dobDate = LocalDate.parse(dob);
		LocalDate currentDate = LocalDate.now();
		
		return Period.between(dobDate, currentDate).getYears();
		
	}

}