package com.ftn.dto;

import com.ftn.model.AdditionalService;

import java.util.ArrayList;
import java.util.List;

public class CreateReservationDTO {
    private String userEmail;
    private VehicleDTO vehicle;
    private String pickUpDate;
    private String returnDate;
    private double price;
    private List<AdditionalService> includedAdditionalServices = new ArrayList<>();

    public CreateReservationDTO() {
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public VehicleDTO getVehicle() {
        return vehicle;
    }

    public void setVehicle(VehicleDTO vehicle) {
        this.vehicle = vehicle;
    }

    public String getPickUpDate() {
        return pickUpDate;
    }

    public void setPickUpDate(String pickUpDate) {
        this.pickUpDate = pickUpDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<AdditionalService> getIncludedAdditionalServices() {
        return includedAdditionalServices;
    }

    public void setIncludedAdditionalServices(List<AdditionalService> includedAdditionalServices) {
        this.includedAdditionalServices = includedAdditionalServices;
    }
}
