package com.ftn.service;

import java.awt.PageAttributes.MediaType;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import java.util.zip.DeflaterOutputStream;

import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import org.joda.time.DateTime;
import org.joda.time.Interval;
import org.joda.time.Period;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;


import com.ftn.dto.SearchDTO;
import com.ftn.dto.SearchVehiclesDTO;
import com.ftn.model.Address;
import com.ftn.model.CarService;
import com.ftn.model.Reservation;
import com.ftn.model.Vehicle;
import com.ftn.model.VehiclePhoto;
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
		
		Collections.sort(listForCity, new SortCarService());
		
		return listForCity;
		
	}


	public List<Vehicle> getVehicles(SearchVehiclesDTO svDTO) {
		
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
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
		
		boolean free = true;
		
		for(Vehicle v : cs.getVehicles()) {
			
		
			free = true;
		
				//byte[] fileContent = FileUtils.readFileToByteArray(new File(v.getImage()));
				//String encodedString = Base64.getEncoder().encodeToString(fileContent);
			
				//System.out.println(multipartFile);
				//System.out.println(encodedString);
				v.setImageFile(v.getImage());
		
			
			v.setPriceForDays(v.getPricelist().getPriceADay()*days);

				for(Reservation r : reservations) {
					if(r.getVehicle() != v) {
						//continue;
						//vehicles.add(v);
					} else {
					
						DateTime dt3 = new DateTime(r.getPickUpDate().getTime());
						DateTime dt4 = new DateTime(r.getReturnDate().getTime());

						Interval interval = new Interval( dt1, dt2 );
						Interval interval2 = new Interval( dt3, dt4 );
						
						if(interval.overlaps(interval2)) {
							free = false;
							break; // nasao poklapanje za dato vozilo u rezervacijama
						}
						
					}
				}
				
				if(free) {
					vehicles.add(v);
				}
			
		}
		
		Collections.sort(vehicles, new SortVehicles());
		System.out.println(vehicles.size());
		return vehicles;
	}
	
	public static byte[] compress(byte[] in) {
	    try {
	        ByteArrayOutputStream out = new ByteArrayOutputStream();
	        DeflaterOutputStream defl = new DeflaterOutputStream(out);
	        defl.write(in);
	        defl.flush();
	        defl.close();

	        return out.toByteArray();
	    } catch (Exception e) {
	        e.printStackTrace();
	        return null;
	    }
	}
	
	public class SortCarService implements Comparator<CarService>
	{

		@Override
		public int compare(CarService o1, CarService o2) {

			return (int) (o1.getId() - o2.getId());
		}
	}
	
	public class SortVehicles implements Comparator<Vehicle>
	{

		@Override
		public int compare(Vehicle o1, Vehicle o2) {

			return (int) (o1.getId() - o2.getId());
		}
	}
	

}
