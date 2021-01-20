package com.qa.persistence.dtos;

public class CatDTO {

	private Long id;
	private String name;
	private int age;
	private float speechVolume;
	
	public CatDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CatDTO(Long id, String name, int age, float speechVolume) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.speechVolume = speechVolume;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "CatDTO [id=" + id + ", name=" + name + ", age=" + age + ", speechVolume=" + speechVolume + "]";
	}
	
}
