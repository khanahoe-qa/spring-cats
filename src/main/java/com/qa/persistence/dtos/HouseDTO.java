package com.qa.persistence.dtos;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HouseDTO {

	private Long id;
	private List<CatDTO> cats;
	private String name;
	
}
