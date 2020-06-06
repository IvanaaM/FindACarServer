package com.ftn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ftn.model.Review;
import com.ftn.service.VehicleService;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {
	
	@Autowired
	private VehicleService vehicleService;


    @GetMapping( path = "/{vehicleId}/reviews", produces = "application/json")
    public List<Review> getReviews(@PathVariable Long vehicleId) {
        List<Review> reviews = vehicleService.findAllByVehicleId(vehicleId);
        return reviews;
    }

}
