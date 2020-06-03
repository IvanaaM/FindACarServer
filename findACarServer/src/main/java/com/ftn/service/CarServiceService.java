package com.ftn.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import org.joda.time.DateTime;
import org.joda.time.Interval;
import org.joda.time.Period;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftn.dto.SearchDTO;
import com.ftn.dto.SearchVehiclesDTO;
import com.ftn.model.Address;
import com.ftn.model.CarService;
import com.ftn.model.Reservation;
import com.ftn.model.Vehicle;
import com.ftn.repository.AddressRepository;
import com.ftn.repository.CarServiceRepository;

@Service
public class CarServiceService {
	
	@Autowired
	CarServiceRepository carSRepository;
	
	@Autowired
	AddressRepository addressRepository;
	
	@Autowired
	ReservationService reservationService;
	
	public List<CarService> getServices(SearchDTO searchDTO){
		
		List<CarService> listForCity = new ArrayList<CarService>();
		
		List<CarService> services = carSRepository.findAll();
		
		for(CarService c : services) {
			if(c.getAddress().getCity().equals(searchDTO.getCity())) {
				listForCity.add(c);
			}
		}
		
		
		return listForCity;
		
	}


	public List<Vehicle> getVehicles(SearchVehiclesDTO svDTO) {
		
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);
	    Date firstDate = new Date();
	    Date secondDate = new Date();
	    
		try {
			firstDate = sdf.parse(svDTO.getPickUpDate());
		    secondDate = sdf.parse(svDTO.getReturnDate());
		} catch (ParseException e) {

			e.printStackTrace();
		}
		
		DateTime dt1 = new DateTime(firstDate.getTime());
		DateTime dt2 = new DateTime(secondDate.getTime());
	 
	    long diffInMillies = Math.abs(secondDate.getTime() - firstDate.getTime());
	    
	    long days = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
		
		List<Vehicle> vehicles = new ArrayList<Vehicle>();
		List<Reservation> reservations = reservationService.getAllRes();
		
		CarService cs = carSRepository.findById(svDTO.getId()).get();
		
		for(Vehicle v : cs.getVehicles()) {
			v.setPriceForDays(v.getPricelist().getPriceADay()*days);
			if(reservations.size() !=0) {
				for(Reservation r : reservations) {
					if(r.getVehicle() != v) {
						vehicles.add(v);
					} else {
						DateTime dt3 = new DateTime(r.getPickUpDate().getTime());
						DateTime dt4 = new DateTime(r.getRetutnDate().getTime());

						Interval interval = new Interval( dt1, dt2 );
						Interval interval2 = new Interval( dt3, dt4 );
						
						if(!interval.overlaps(interval2)) {
							vehicles.add(v);
						}
						
					}
				}
				
			} else {
				vehicles.add(v);
			}
		}
		
		return vehicles;
	}

}
