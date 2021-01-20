package com.qa.persistence.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cat {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	private String name;
	private int age;
	private float speechVolume;
	
	// empty constructor
	public Cat() {
		super();
		this.age = 0;
		this.name = "";
		this.speechVolume = 11;
	}

	// full constructor
	public Cat(String name, int age, float speechVolume) {
		super();
		this.name = name;
		this.age = age;
		this.speechVolume = speechVolume;
	}

	// getters and setters
	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public float getSpeechVolume() {
		return speechVolume;
	}

	public void setSpeechVolume(float speechVolume) {
		this.speechVolume = speechVolume;
	}

	// toString
	@Override
	public String toString() {
		return "Cat [Id=" + Id + ", name=" + name + ", age=" + age + ", speechVolume=" + speechVolume + "]";
	}
	
}
