package com.qa.persistence.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cat {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Exclude
	private Long Id;
	
	@NotNull
	private String name;
	
	@NotNull
	private int age;
	
	private float speechVolume;
	
	@ManyToOne
	private House house = null;
	
	// full constructor
	public Cat(String name, int age, float speechVolume) {
		super();
		this.name = name;
		this.age = age;
		this.speechVolume = speechVolume;
	}
	
}
