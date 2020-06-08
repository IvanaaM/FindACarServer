package com.ftn.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity(name="Vehicle")
public class Vehicle implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name="Name")
	private String name;
	
	@Column(name="Description")
    private String description;

	@Column(name="Seats")
	private int seats;
	
	@Column(name="Doors")
    private int doors;

	@Column(name="Cases")
    private int cases;
	
	@Column(name="Type")
    private String type;
	
	@Column(name="AirCond")
    private boolean airCond;
	
	@Column(name="Autom")
    private boolean autom;
	
	@Column(name="RegUntil")
    private String regUntil;
	
	@Column(name="ProductionYear")
    private int prodYear;
	
	@Column(name="Fuel")
    private String fuel;
	
	@Column(name="Deposit")
	private boolean deposit;
	
	@Column(name="Mileage")
	private String mileage;
	
	@Transient
	private double priceForDays;
	
	@OneToOne
	private Pricelist pricelist;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<Review> reviews = new HashSet<Review>();
	
    @Column(name="Image")
    @JsonIgnore
    private String image;
    
    @Transient
    private String imageFile = image;
    // images;
    
	@Column(name="Cancel")
	private int cancel;

	public Vehicle() {
		super();
		this.imageFile = image;
		
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getSeats() {
		return seats;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}

	public int getDoors() {
		return doors;
	}

	public void setDoors(int doors) {
		this.doors = doors;
	}

	public int getCases() {
		return cases;
	}

	public void setCases(int cases) {
		this.cases = cases;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean isAirCond() {
		return airCond;
	}

	public void setAirCond(boolean airCond) {
		this.airCond = airCond;
	}

	public boolean isAutom() {
		return autom;
	}

	public void setAutom(boolean autom) {
		this.autom = autom;
	}

	public String getRegUntil() {
		return regUntil;
	}

	public void setRegUntil(String regUntil) {
		this.regUntil = regUntil;
	}

	public int getProdYear() {
		return prodYear;
	}

	public void setProdYear(int prodYear) {
		this.prodYear = prodYear;
	}

	public String getFuel() {
		return fuel;
	}

	public void setFuel(String fuel) {
		this.fuel = fuel;
	}

	public boolean isDeposit() {
		return deposit;
	}

	public void setDeposit(boolean deposit) {
		this.deposit = deposit;
	}

	public String getMileage() {
		return mileage;
	}

	public void setMileage(String mileage) {
		this.mileage = mileage;
	}

	public Set<Review> getReviwes() {
		return reviews;
	}

	public void setReviews(Set<Review> reviews) {
		this.reviews = reviews;
	}

	public double getPriceForDays() {
		return priceForDays;
	}

	public void setPriceForDays(double priceForDays) {
		this.priceForDays = priceForDays;
	}

	public Pricelist getPricelist() {
		return pricelist;
	}

	public void setPricelist(Pricelist pricelist) {
		this.pricelist = pricelist;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getImageFile() {
		this.imageFile = this.image;
		return imageFile;
	}

	public void setImageFile(String imageFile) {
		this.imageFile = imageFile;
	}

	public int getCancel() {
		return cancel;
	}

	public void setCancel(int cancel) {
		this.cancel = cancel;
	}

	public Set<Review> getReviews() {
		return reviews;
	}
	
	
}
