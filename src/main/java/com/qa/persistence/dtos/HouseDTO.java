package com.qa.persistence.dtos;

import java.util.ArrayList;
import java.util.List;

import com.qa.persistence.domain.Cat;

public class HouseDTO {

	private Long id;
	private List<Cat> cats = new ArrayList<>();
	private String name;

	public HouseDTO(String name) {
		this.name = name;
	}
	
	public HouseDTO(Long id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Cat> getCats() {
		return cats;
	}

	public void setCats(List<Cat> cats) {
		this.cats = cats;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "House [id=" + id + ", cats=" + cats + ", name=" + name + "]";
	}
	
}
