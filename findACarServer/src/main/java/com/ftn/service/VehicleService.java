package com.ftn.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftn.model.Review;
import com.ftn.model.Vehicle;
import com.ftn.repository.VehicleRepository;

@Service
public class VehicleService {
	
	@Autowired
	VehicleRepository vehicleRepository;

	public List<Review> findAllByVehicleId(Long vehicleId) {
		
		Vehicle v = vehicleRepository.findById(vehicleId).get();
		List<Review> reviews = new ArrayList<Review>();
		
		for(Review r : v.getReviwes()) {
			reviews.add(r);
		}
		
		return reviews;
	}

	public Vehicle findById(Long id){
		Vehicle vehicle = null;
		if (vehicleRepository.findById(id).isPresent()) {
			vehicle = vehicleRepository.findById(id).get();
		}
		return vehicle;
	}

}
