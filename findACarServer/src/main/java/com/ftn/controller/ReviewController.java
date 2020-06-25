package com.ftn.controller;

import com.ftn.dto.RegisterDTO;
import com.ftn.dto.CreateReviewDTO;
import com.ftn.model.Review;
import com.ftn.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewController {
    private ReviewService reviewService;

    @Autowired
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }
    
    @PostMapping("/add")
    public ResponseEntity<Void> register(@RequestBody CreateReviewDTO reviewDTO) {

        reviewService.addReview(reviewDTO);
        
        return ResponseEntity.ok().build();
    }

}
