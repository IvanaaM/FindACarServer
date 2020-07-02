package com.ftn.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name="CarService")
public class CarService {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name="Name")
	private String name;
	
	@Column(name="Phone")
	private String phone;

	@Column
	private String landlinePhone;
	
	@Column(name="Email")
	private String email;
	
	@OneToOne
	private Address address;
	
	@Column(name="About")
	private String about;
	
	@ManyToMany
	private Set<AdditionalService> additionalServices = new HashSet<>();
	
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JsonIgnore
	private Set<Vehicle> vehicles = new HashSet<Vehicle>();

	public CarService() {
		super();
		
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

	public Set<Vehicle> getVehicles() {
		return vehicles;
	}

	public void setVehicles(Set<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}

	public String getLandlinePhone() {
		return landlinePhone;
	}

	public void setLandlinePhone(String landlinePhone) {
		this.landlinePhone = landlinePhone;
	}

	public Set<AdditionalService> getAdditionalServices() {
		return additionalServices;
	}

	public void setAdditionalServices(Set<AdditionalService> additionalServices) {
		this.additionalServices = additionalServices;
	}
	

}
