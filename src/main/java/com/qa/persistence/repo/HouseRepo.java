package com.qa.persistence.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.persistence.domain.House;

@Repository
public interface HouseRepo extends JpaRepository<House, Long> {

}
