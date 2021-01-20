package com.qa.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.persistence.domain.House;
import com.qa.persistence.dtos.HouseDTO;
import com.qa.persistence.repo.HouseRepo;
import com.qa.utils.MyBeanUtils;

@Service
public class HouseService {

	private HouseRepo repo;
	private ModelMapper mapper;
	
	@Autowired
	public HouseService(HouseRepo repo, ModelMapper mapper) {
		super();
		this.repo = repo;
		this.mapper = mapper;
	}
	
	private HouseDTO mapToDTO(House model) {
		return this.mapper.map(model, HouseDTO.class);
	}
	
	// Create
	public HouseDTO addHouse(House model) {
		return mapToDTO(this.repo.save(model));
	}
	
	// Read all
	public List<HouseDTO> getAllHouses(){
		List<House> houseList = repo.findAll();
		List<HouseDTO> houseListDTO = houseList.stream().map(this::mapToDTO).collect(Collectors.toList());
		return houseListDTO;
	}
	
	// Read one
	public HouseDTO getHouse(Long id) {
		return mapToDTO(this.repo.findById(id).orElseThrow());
	}
	
	// Update
	public HouseDTO updateHouse(Long id, House model) {
		House existing = this.repo.findById(id).orElseThrow();
		existing.setCats(model.getCats());
		existing.setName(model.getName());
		MyBeanUtils.mergeNotNull(model, existing);
		return mapToDTO(this.repo.save(existing));
	}
	
	// Delete
	public boolean removeHouse(Long id) {
		this.repo.deleteById(id);
		return !this.repo.existsById(id);
	}
}
