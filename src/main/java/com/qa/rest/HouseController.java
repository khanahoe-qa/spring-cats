package com.qa.rest;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.persistence.domain.House;
import com.qa.persistence.dtos.HouseDTO;
import com.qa.services.HouseService;

@RestController
@RequestMapping("/house")
public class HouseController {

	private HouseService service;
	private static Long currentId = 0L;
	
	@Autowired
	public HouseController(HouseService service) {
		super();
		this.service = service;
	}
	
	// GET
	@GetMapping("/readAll")
	public ResponseEntity<List<HouseDTO>> readAll() {
		return ResponseEntity.ok(this.service.getAllHouses());
	}
	
	@GetMapping("/read/{id}")
	public ResponseEntity<HouseDTO> readHouse(@PathVariable("id") Long id) {
		return new ResponseEntity<HouseDTO>(this.service.getHouse(id), HttpStatus.OK);
	}
	
	// POST
	@PostMapping("/create")
	public ResponseEntity<HouseDTO> create(@RequestBody House house) {
		house.setId(currentId);
		++currentId;
		return new ResponseEntity<HouseDTO>(this.service.addHouse(house), HttpStatus.CREATED);
	}
	
	// PUT
	@PutMapping("/update")
	public ResponseEntity<HouseDTO> update(@PathParam("id") Long id, @RequestBody House house) {
		return new ResponseEntity<HouseDTO>(this.service.updateHouse(id, house), HttpStatus.ACCEPTED);
	}

	// DELETE
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<HouseDTO> delete(@PathVariable("id") Long id) {
		return this.service.removeHouse(id) ?
				new ResponseEntity<>(HttpStatus.NO_CONTENT) :
				new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
