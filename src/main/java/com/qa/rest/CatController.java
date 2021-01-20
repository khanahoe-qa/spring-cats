package com.qa.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

import com.qa.persistence.domain.Cat;
import com.qa.persistence.dtos.CatDTO;
import com.qa.services.CatService;

@RestController
@RequestMapping("/cat")
public class CatController {

	private CatService service;
	private static Long currentId = 0L;
	
	@Autowired
	public CatController(CatService service) {
		super();
		this.service = service;
	}
	
	// GET
	@GetMapping("/greetings")
	public String helloWorld() {
		return "Hello world";
	}
	
	@GetMapping("/readAll")
	public ResponseEntity<List<CatDTO>> readAll() {
		return ResponseEntity.ok(this.service.getAllCats());
	}
	
	@GetMapping("/read/{id}")
	public ResponseEntity<CatDTO> readCat(@PathVariable("id") Long id) {
		return new ResponseEntity<CatDTO>(this.service.getCat(id), HttpStatus.OK);
	}
	
	// POST
	@PostMapping("/create")
	public ResponseEntity<CatDTO> create(@RequestBody Cat cat) {
		cat.setId(currentId);
		++currentId;
		return new ResponseEntity<CatDTO>(this.service.addCat(cat), HttpStatus.CREATED);
	}
	
	// PUT
	@PutMapping("/update")
	public ResponseEntity<CatDTO> update(@PathParam("id") Long id, @RequestBody Cat cat) {
		return new ResponseEntity<CatDTO>(this.service.updateCat(id, cat), HttpStatus.ACCEPTED);
	}

	// DELETE
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<CatDTO> delete(@PathVariable("id") Long id) {
		return this.service.removeCat(id) ?
				new ResponseEntity<>(HttpStatus.NO_CONTENT) :
				new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
