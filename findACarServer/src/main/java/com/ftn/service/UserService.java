package com.ftn.service;

import com.ftn.utils.PasswordUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftn.dto.LogInDTO;
import com.ftn.model.Reservation;
import com.ftn.model.User;
import com.ftn.model.Vehicle;
import com.ftn.repository.UserRepository;
import com.ftn.service.CarServiceService.SortVehicles;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    
    @Autowired
    ReservationService resService;

    public boolean logIn(LogInDTO userDTO) {
        boolean success = false;
        User u = userRepository.findByEmail(userDTO.getEmail());

        if (u != null && u.isEmailVerified()) {
            if (PasswordUtils.verifyUserPassword(userDTO.getPassword(), u.getPassword(), u.getSalt())) {
                success = true;
            }
        }
        return success;
    }

    public boolean insert(User user) {
        boolean success = false;
        if (userRepository.save(user) != null) {
            success = true;
        }
        return success;
    }

    public boolean edit(User user) {
        boolean success = false;
        if (findById(user.getId()) != null) {
            User edited = userRepository.save(user);
            if (edited != null) {
                success = true;
            }
        }
        return success;
    }

    public User findById(Long userId) {
        User user = null;
        if (userRepository.findById(userId).isPresent()) {
            user = userRepository.findById(userId).get();
        }
        return user;
    }

    public User findByToken(String token) {
        return userRepository.findByToken(token);
    }
    
    public List<Reservation> findUserReservations(String email){
    	
    	User u = userRepository.findByEmail(email + ".com");
    	
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

		resService.reservationRepository.deleteById(id);
		
	}


}
