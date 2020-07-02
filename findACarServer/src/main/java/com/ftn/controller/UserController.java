package com.ftn.controller;

import com.ftn.dto.RegisterDTO;
import com.ftn.dto.ReservationDTO;
import com.ftn.dto.UserDTO;
import com.ftn.model.Reservation;
import com.ftn.model.User;
import com.ftn.model.Vehicle;
import com.ftn.service.AuthService;

import java.util.ArrayList;
import java.util.List;

import com.ftn.service.ReservationService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.ftn.dto.LogInDTO;
import com.ftn.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

    UserService userService;
    AuthService authService;
    private ReservationService reservationService;

    public UserController(UserService userService, AuthService authService, ReservationService reservationService) {
        this.userService = userService;
        this.authService = authService;
        this.reservationService = reservationService;
    }

    @RequestMapping(path = "/logIn", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> logIn(@RequestBody LogInDTO userDTO) {

        boolean exists = userService.logIn(userDTO);

        if (exists) {
            User u = userService.findByEmail(userDTO.getEmail());
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            return new ResponseEntity<UserDTO>(new UserDTO(u), headers, HttpStatus.OK);
        } else {
            //return new ResponseEntity<Boolean>(false, HttpStatus.OK);
            return ResponseEntity.badRequest().build();
        }

    }

    @PostMapping("/auth/register")
    public ResponseEntity<Void> register(@RequestBody RegisterDTO registerDTO) {

        if (authService.register(registerDTO)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/confirm-registration/{token}")
    public ResponseEntity<Void> confirmRegistration(@PathVariable String token) {
        if (authService.verifyEmail(token)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @RequestMapping(path = "/res/{email}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<ReservationDTO>> getUserReservations(@PathVariable String email) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        List<ReservationDTO> retVal = (ArrayList) ReservationDTO.asReservationsDTO(reservationService.findUserReservations(email));
        return new ResponseEntity<List<ReservationDTO>>(retVal, headers, HttpStatus.OK);

    }

    @RequestMapping(path = "/res/cancelRes/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Boolean> removeRes(@PathVariable long id) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        reservationService.removeReservation(id);
        return new ResponseEntity<Boolean>(true, headers, HttpStatus.OK);

    }

    @PutMapping("/{email}/{fcmToken}")
    public ResponseEntity<Void> registerUserDevice(@PathVariable String email, @PathVariable String fcmToken) {
        if (userService.registerUserDevice(email, fcmToken)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/addFavorite/{email}/{idVehicle}")
    public ResponseEntity<Void> addToFavorites(@PathVariable String email, @PathVariable long idVehicle) {

        if (userService.addVehicleToFavorites(email, idVehicle)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.badRequest().build();
        }

    }

    @DeleteMapping("/{email}/favorite-vehicles/{vehicleId}")
    public ResponseEntity<Void> removeVehicleFromFavorites(@PathVariable String email, @PathVariable long vehicleId) {
        if (userService.removeVehicleFromFavorites(email, vehicleId)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.badRequest().build();
        }

    }
}
