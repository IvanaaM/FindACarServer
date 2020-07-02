package com.ftn.controller;

import com.ftn.dto.RegisterDTO;
import com.ftn.dto.CreateReviewDTO;
import com.ftn.dto.ReservationDTO;
import com.ftn.model.Review;
import com.ftn.service.ReservationService;
import com.ftn.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewController {
    private ReviewService reviewService;
    private ReservationService reservationService;

    @Autowired
    public ReviewController(ReviewService reviewService, ReservationService reservationService) {
        this.reviewService = reviewService;
        this.reservationService = reservationService;
    }
    
    @PostMapping("/add")
    public ResponseEntity<List<ReservationDTO>> register(@RequestBody CreateReviewDTO reviewDTO) {

        reviewService.addReview(reviewDTO);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        List<ReservationDTO> retVal = (ArrayList) ReservationDTO.asReservationsDTO(reservationService.findUserPreviousReservations(reviewDTO.getEmail()));
        return new ResponseEntity<List<ReservationDTO>>(retVal, headers, HttpStatus.OK);
    }

}
