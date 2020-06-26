package com.ftn.dto;

import java.util.ArrayList;
import java.util.List;

import com.ftn.model.Pricelist;
import com.ftn.model.Review;
import com.ftn.model.Vehicle;
import com.ftn.model.VehiclePhoto;

public class VehicleDTO {

    private long vehicleId;
    private long id;
    private String name;
    private String description;
    private int seats;
    private int doors;
    private int cases;
    private String type;
    private boolean airCond;
    private boolean autom;
    private String regUntil;
    private int prodYear;
    private String fuel;
    private boolean deposit;
    private String mileage;
    private double priceForDays;
    private Pricelist pricelist;
    private String imageFile;
    private String image;
    private List<VehiclePhoto> vehiclePhotos;
    private int cancel;
    private List<ReviewDTO> reviews;
    private long version;

    public VehicleDTO() {
    }

    public VehicleDTO(Vehicle vehicle) {
        id = vehicle.getId();
        name = vehicle.getName();
        description = vehicle.getDescription();
        seats = vehicle.getSeats();
        doors = vehicle.getDoors();
        cases = vehicle.getCases();
        type = vehicle.getType();
        airCond = vehicle.isAirCond();
        autom = vehicle.isAutom();
        regUntil = vehicle.getRegUntil();
        prodYear = vehicle.getProdYear();
        fuel = vehicle.getFuel();
        deposit = vehicle.isDeposit();
        mileage = vehicle.getMileage();
        priceForDays = vehicle.getPriceForDays();
        pricelist = vehicle.getPricelist();
        imageFile = vehicle.getImageFile();
        image = vehicle.getImage();
        vehiclePhotos = new ArrayList<>(vehicle.getVehiclePhotos());
        cancel = vehicle.getCancel();
        reviews = (ArrayList) Review.asReviewsDTO(vehicle.getReviews());
        version = vehicle.getVersion();
    }

    public long getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(long vehicleId) {
        this.vehicleId = vehicleId;
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

    public double getPriceForDays() {
        return priceForDays;
    }

    public void setPriceForDays(double priceForDays) {
        this.priceForDays = priceForDays;
    }

    public String getImageFile() {
        return imageFile;
    }

    public void setImageFile(String imageFile) {
        this.imageFile = imageFile;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getCancel() {
        return cancel;
    }

    public void setCancel(int cancel) {
        this.cancel = cancel;
    }

    public List<ReviewDTO> getReviews() {
        return reviews;
    }

    public void setReviews(List<ReviewDTO> reviews) {
        this.reviews = reviews;
    }

    public Pricelist getPricelist() {
        return pricelist;
    }

    public void setPricelist(Pricelist pricelist) {
        this.pricelist = pricelist;
    }

    public List<VehiclePhoto> getVehiclePhotos() {
        return vehiclePhotos;
    }

    public void setVehiclePhotos(List<VehiclePhoto> vehiclePhotos) {
        this.vehiclePhotos = vehiclePhotos;
    }

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }


}
