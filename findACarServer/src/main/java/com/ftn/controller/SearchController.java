package com.ftn.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ftn.dto.LogInDTO;
import com.ftn.dto.SearchDTO;
import com.ftn.dto.SearchVehiclesDTO;
import com.ftn.model.CarService;
import com.ftn.model.Vehicle;
import com.ftn.service.CarServiceService;

@RestController
@RequestMapping("/search")
public class SearchController {
	
	@Autowired
	CarServiceService carService;
	
	 @PostMapping(path = "/findCity", produces = "application/json; charset=UTF-8")
	    public List<CarService> searchCity(@RequestBody SearchDTO searchDTO) {

	        return carService.getServices(searchDTO);

	    }
	 
	 @PostMapping(path = "/findForDates", produces = "application/json; charset=UTF-8")
	    public List<Vehicle> searchDates(@RequestBody SearchVehiclesDTO svDTO) {

	        return carService.getVehicles(svDTO);

	    }

}
