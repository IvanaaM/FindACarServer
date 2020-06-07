package com.ftn.service;

import com.ftn.dto.ReviewDTO;
import com.ftn.model.Reservation;
import com.ftn.model.Review;
import com.ftn.model.User;
import com.ftn.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Date;
import java.util.List;

@Service
public class ReviewService {

	@Autowired
    ReviewRepository reviewRepository;
    
    @Autowired
    UserService userService;
    
    @Autowired
    ReservationService reservationService;

    @Autowired
    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

	public void addReview(ReviewDTO reviewDTO) {

		User u = userService.userRepository.findByEmail(reviewDTO.getEmail());
		
		Reservation r = reservationService.reservationRepository.findById(reviewDTO.getResId()).get();
		
		Review review = new Review();
		review.setComment(reviewDTO.getComment());
		review.setRating(Double.parseDouble(reviewDTO.getRating()));
		review.setDate(new Date());
		
		Review rev = reviewRepository.save(review);
		
		r.setReview(rev);
		r.getVehicle().getReviwes().add(rev);
		
	}


}
