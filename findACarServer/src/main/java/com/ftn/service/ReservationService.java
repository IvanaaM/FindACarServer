package com.ftn.service;

import java.util.*;

import com.ftn.dto.CreateReservationDTO;
import com.ftn.model.User;
import com.ftn.model.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftn.model.Reservation;
import com.ftn.repository.ReservationRepository;

@Service
public class ReservationService {


    ReservationRepository reservationRepository;
    private UserService userService;
    private VehicleService vehicleService;

    public ReservationService(ReservationRepository reservationRepository, UserService userService, VehicleService vehicleService) {
        this.reservationRepository = reservationRepository;
        this.userService = userService;
        this.vehicleService = vehicleService;
    }

    public List<Reservation> getAllRes() {
        return reservationRepository.findAll();
    }

    public boolean insert(CreateReservationDTO newReservation) {

        boolean success = false;
        User user = userService.findByEmail(newReservation.getUserEmail());
        if (user != null) {
            Vehicle vehicle = vehicleService.findById(newReservation.getVehicle().getId());
            if (vehicle != null) {
					Reservation reservation = new Reservation(newReservation, new HashSet<>(), vehicle, user);
					reservationRepository.save(reservation);
					success = true;
            }
        }
        return success;
    }

	public List<Reservation> findUserReservations(String email){

		User u = userService.findByEmail(email + ".com");

		List<Reservation> res = new ArrayList<Reservation>();
		if(u==null) {
			System.out.println("error");
		} else {

			for(Reservation r : u.getReservations()) {
				res.add(r);
			}

		}

		Collections.sort(res, new SortRes());
		return res;
	}

	public class SortRes implements Comparator<Reservation>
	{

		@Override
		public int compare(Reservation o1, Reservation o2) {

			return (int) (o1.getId() - o2.getId());
		}
	}

	public void removeReservation(long id) {

		reservationRepository.deleteById(id);

	}


}
