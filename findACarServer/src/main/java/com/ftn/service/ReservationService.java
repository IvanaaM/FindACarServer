package com.ftn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftn.model.Reservation;
import com.ftn.repository.ReservationRepository;

@Service
public class ReservationService {
	
	@Autowired
	ReservationRepository reservationRepository;

	
	public List<Reservation> getAllRes(){
		return reservationRepository.findAll();
	}
	
	

}
