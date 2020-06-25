package com.ftn.dto;

import java.util.List;

import com.ftn.model.Address;
import com.ftn.model.Vehicle;

public class CarServiceDTO {
	
	private long id;
	private String name;
	private String phone;
	private String landlinePhone;
	private String email;
	private Address address;
	private String about;
	private List<Vehicle> vehicles;
	
	
	public CarServiceDTO() {
		super();
	}
	
	public CarServiceDTO(long id, String name, String phone, String landlinePhone, String email, Address address,
			String about, List<Vehicle> vehicles) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.landlinePhone = landlinePhone;
		this.email = email;
		this.address = address;
		this.about = about;
		this.vehicles = vehicles;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getLandlinePhone() {
		return landlinePhone;
	}
	public void setLandlinePhone(String landlinePhone) {
		this.landlinePhone = landlinePhone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String getAbout() {
		return about;
	}
	public void setAbout(String about) {
		this.about = about;
	}
	public List<Vehicle> getVehicles() {
		return vehicles;
	}
	public void setVehicles(List<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}
	
	
	

}
