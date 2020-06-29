package com.ftn.dto;

import com.ftn.model.User;
import com.ftn.model.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class UserDTO {
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private List<VehicleDTO> favorites = new ArrayList<>();

    public UserDTO(long id, String firstName, String lastName, String email, List<VehicleDTO> favorites) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.favorites = favorites;
    }

    public UserDTO(User user) {
        this.id = user.getId();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.email = user.getEmail();
        this.favorites = (ArrayList)Vehicle.asVehiclesDto(user.getFavorites());
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<VehicleDTO> getFavorites() {
        return favorites;
    }

    public void setFavorites(List<VehicleDTO> favorites) {
        this.favorites = favorites;
    }
}
