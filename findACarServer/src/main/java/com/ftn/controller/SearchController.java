package com.ftn.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import com.ftn.dto.VehicleDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
	 
	 @PostMapping(path = "/findForDates", produces = "application/json", consumes="application/json")
	    public List<VehicleDTO> searchDates(@RequestBody SearchVehiclesDTO svDTO) {
			List<VehicleDTO> vehicles = (ArrayList)Vehicle.asVehiclesDto(carService.getVehicles(svDTO));
	        return vehicles;

	    }
	 
	 @RequestMapping(path = "/getImage/{imageName}", method = RequestMethod.GET)
	 @ResponseBody
	 public ResponseEntity<byte[]> getImage(@PathVariable String imageName) throws IOException {
		 
		 File imgPath = new File("./images/" + imageName + ".jpg");

		 byte[] image = Files.readAllBytes(imgPath.toPath());
		    HttpHeaders headers = new HttpHeaders();
		    headers.setContentType(MediaType.IMAGE_JPEG);
		    headers.setContentLength(image.length);
		    return new ResponseEntity<>(image, headers, HttpStatus.OK);
	    }

}
