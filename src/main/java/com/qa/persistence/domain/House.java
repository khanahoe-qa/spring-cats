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

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class House {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Exclude
	private Long id;
	
	@OneToMany(mappedBy = "house")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private List<Cat> cats = new ArrayList<>();
	
	private String name;
	
	public House(String name) {
		super();
		this.name = name;
	}
	
	public House(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
}
