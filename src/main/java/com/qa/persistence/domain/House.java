package com.qa.persistence.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
public class House {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToMany(mappedBy = "house")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private List<Cat> cats = new ArrayList<>();
	
	private String name;

	public House(String name) {
		this.name = name;
	}
	
	public House(Long id, String name) {
		this.id = id;
		this.name = name;
	}
	
	
}
