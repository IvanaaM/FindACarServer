package com.ftn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ftn.model.Address;
import com.ftn.model.CarService;

@Repository
public interface CarServiceRepository extends JpaRepository<CarService, Long> {
	
	List<CarService> findByAddress(Address address);

}
