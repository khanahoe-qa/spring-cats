package com.qa.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.persistence.domain.Cat;
import com.qa.persistence.dtos.CatDTO;
import com.qa.persistence.repo.CatRepo;
import com.qa.utils.MyBeanUtils;

@Service
public class CatService {

	private CatRepo repo;
	private ModelMapper mapper;
	
	@Autowired
	public CatService(CatRepo repo, ModelMapper mapper) {
		super();
		this.repo = repo;
		this.mapper = mapper;
	}
	
	// Converts Cat object into CatDTO object
	private CatDTO mapToDTO(Cat model) {
		return this.mapper.map(model, CatDTO.class);
	}
	
	// Create
	public CatDTO addCat(Cat model) {
		return mapToDTO(this.repo.save(model));
	}
	
	// Read all
	public List<CatDTO> getAllCats(){
		List<Cat> catList = repo.findAll();
		List<CatDTO> catListDTO = catList.stream().map(this::mapToDTO).collect(Collectors.toList());
		return catListDTO;
	}
	
	// Read one
	public CatDTO getCat(Long id) {
		return mapToDTO(this.repo.findById(id).orElseThrow());
	}
	
	// Update
	public CatDTO updateCat(Long id, Cat cat) {
		Cat existing = this.repo.findById(id).orElseThrow();
		existing.setAge(cat.getAge());
		existing.setName(cat.getName());
		MyBeanUtils.mergeNotNull(cat, existing);
		return mapToDTO(this.repo.save(existing));
	}
	
	// Delete
	public boolean removeCat(Long id) {
		this.repo.deleteById(id);
		return !this.repo.existsById(id);
	}
}
