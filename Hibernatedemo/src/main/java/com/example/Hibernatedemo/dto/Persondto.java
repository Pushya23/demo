package com.example.Hibernatedemo.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.example.Hibernatedemo.model.Person;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Persondto {
	
	@NotBlank
	private String firstName;
	
	@Size(min = 1, max = 45)
	private String lastName;
	
	@NotBlank
	private String dob;
	
	public Person toPerson() {
		return Person.builder().firstName(firstName).lastName(lastName).DoB(dob).build();
	}

}