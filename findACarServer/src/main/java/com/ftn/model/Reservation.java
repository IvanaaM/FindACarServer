package com.ftn.model;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.ftn.dto.CreateReservationDTO;

@Entity(name = "Reservation")
public class Reservation implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    private Vehicle vehicle;

    @Column(name = "PickUpDate")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date pickUpDate;

    @Column(name = "ReturnDate")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date returnDate;

    @Column(name = "Price")
    private double price;

    @OneToOne
    private Review review;

    @ManyToOne
    private User user;

    @ManyToMany
    private Set<AdditionalService> includedAdditionalServices = new HashSet<>();

    public Reservation() {
        super();

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Date getPickUpDate() {
        pickUpDate = setDate(pickUpDate);
        return pickUpDate;
    }

    public void setPickUpDate(Date pickUpDate) {
        this.pickUpDate = pickUpDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getReturnDate() {
        returnDate = setDate(returnDate);
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public Review getReview() {
        return review;
    }

    public void setReview(Review review) {
        this.review = review;
    }

    public Date setDate(Date date2) {
        String pattern = "yyyy-MM-dd HH:mm:ss";

        DateFormat df = new SimpleDateFormat(pattern);
        String date = df.format(date2);
        Calendar c = Calendar.getInstance();
        try {
            c.setTime(df.parse(date));
            c.add(Calendar.DAY_OF_MONTH, 1);
            String newDate = df.format(c.getTime());
            date2 = df.parse(newDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return date2;
    }


    public Set<AdditionalService> getIncludedAdditionalServices() {
        return includedAdditionalServices;
    }

    public void setIncludedAdditionalServices(Set<AdditionalService> includedAdditionalServices) {
        this.includedAdditionalServices = includedAdditionalServices;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Reservation(CreateReservationDTO dto, Set<AdditionalService> includedAdditionalServices, Vehicle vehicle, User user) {
        this.vehicle = vehicle;
        String pattern = "yyyy-MM-dd HH:mm:ss";
        DateFormat dateFormat = new SimpleDateFormat(pattern);
        try {
            this.pickUpDate = dateFormat.parse(dto.getPickUpDate());
            this.returnDate = dateFormat.parse(dto.getReturnDate());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        this.user = user;
        this.price = dto.getPrice();
        this.includedAdditionalServices = includedAdditionalServices;

    }
}
