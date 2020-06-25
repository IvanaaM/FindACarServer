package com.ftn.dto;

public class AddressDTO {
	
	private long id;
	private String street;
	private String city;
	private String country;
	private String postalCode;
	private double x;
	private double y;
	
	
	public AddressDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AddressDTO(long id, String street, String city, String country, String postalCode, double x, double y) {
		super();
		this.id = id;
		this.street = street;
		this.city = city;
		this.country = country;
		this.postalCode = postalCode;
		this.x = x;
		this.y = y;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
	
	

}
