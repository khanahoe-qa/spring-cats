package com.qa.persistence.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Cat {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Exclude
	private Long Id;
	
	private String name;
	private int age;
	private float speechVolume;
	
	// full constructor
	public Cat(String name, int age, float speechVolume) {
		super();
		this.name = name;
		this.age = age;
		this.speechVolume = speechVolume;
	}
	
}
