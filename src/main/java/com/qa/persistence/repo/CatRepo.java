package com.qa.persistence.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.persistence.domain.Cat;


@Repository
public interface CatRepo extends JpaRepository<Cat, Long>{

	// CRUD
	
	// create
	// read
	// update
	// delete
	
	// custom SQL queries
}
