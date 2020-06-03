package com.ftn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ftn.model.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
	
	Address findByCity(String city);

}
