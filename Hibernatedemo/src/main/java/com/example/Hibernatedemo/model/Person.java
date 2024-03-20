package com.example.Hibernatedemo.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Person {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "person_seq")
	@SequenceGenerator(name = "person_seq", sequenceName = "person_seq", initialValue = 1, allocationSize = 5)
	private int id;
	
	private String firstName;
	
	private String lastName;
	
	private int age;
	
	private String DoB;

}