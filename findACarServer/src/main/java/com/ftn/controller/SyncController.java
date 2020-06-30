package com.ftn.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ftn.dto.SyncRequestDTO;
import com.ftn.dto.SyncResponseDTO;
import com.ftn.model.Review;
import com.ftn.model.Vehicle;
import com.ftn.service.VehicleService;


@RestController
@RequestMapping("/sync")
public class SyncController {
	
	@Autowired
	VehicleService vehicleService;
	
	@RequestMapping(path = "/check", method = RequestMethod.POST)
    @ResponseBody
    public List<SyncResponseDTO> checkSync(@RequestBody List<SyncRequestDTO> syncDTOs) {
		
		List<SyncResponseDTO> news = new ArrayList<SyncResponseDTO>();
		
		for(SyncRequestDTO check : syncDTOs) {
			
			Vehicle v =  vehicleService.findById(check.getId());
			
			if(check.getVersion() == v.getVersion()) {
				continue;
	
			} else {
				
				SyncResponseDTO srd = new SyncResponseDTO();
				
				
				srd.setNewVersion(v.getVersion());
				srd.setVehicleId(check.getVehicleId());
				srd.setNewReviews((ArrayList)Review.asReviewsDTO(v.getReviews()));
				
				news.add(srd);
			}
			
		}
		
		return news;
		
	}

}
