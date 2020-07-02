package com.ftn.dto;

import com.ftn.model.Reservation;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ReservationDTO {
    private Long id;
    private String userEmail;
    private VehicleDTO vehicle;
    private String pickUpDate;
    private String returnDate;
    private double price;
    private ReviewDTO review;

    public ReservationDTO(Long id, String userEmail, VehicleDTO vehicle, String pickUpDate, String returnDate, double price) {
        this.id = id;
        this.userEmail = userEmail;
        this.vehicle = vehicle;
        this.pickUpDate = pickUpDate;
        this.returnDate = returnDate;
        this.price = price;
    }

    public ReservationDTO(Reservation reservation) {
        this.id = reservation.getId();
        this.userEmail = reservation.getUser().getEmail();
        this.vehicle = new VehicleDTO(reservation.getVehicle());
        String pattern = "yyyy-MM-dd'T'HH:mm:ss";

        DateFormat df = new SimpleDateFormat(pattern);
        this.pickUpDate = df.format(reservation.getPickUpDate());;
        this.returnDate = df.format(reservation.getReturnDate());;
        this.price = reservation.getPrice();
        this.review =ReviewDTO.newInstance(reservation.getReview());
    }

    public static Collection<ReservationDTO> asReservationsDTO(Collection<Reservation> reviews){
        List<ReservationDTO> retVal = new ArrayList<>();
        reviews.forEach(res -> retVal.add(new ReservationDTO(res)));
        return retVal;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}
