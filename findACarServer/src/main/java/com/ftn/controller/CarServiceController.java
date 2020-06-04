package com.ftn.controller;

import com.ftn.model.CarService;
import com.ftn.model.Review;
import com.ftn.service.CarServiceService;
import com.ftn.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/carservices")
public class CarServiceController {

    private CarServiceService carServiceService;
    private ReviewService reviewService;

    @Autowired
    public CarServiceController(CarServiceService carServiceService, ReviewService reviewService) {
        this.carServiceService = carServiceService;
        this.reviewService = reviewService;
    }

    @GetMapping( path = "/{carServiceId}/reviews", produces = "application/json; charset=UTF-8")
    public List<Review> getReviews(@PathVariable Long carServiceId) {
        List<Review> reviews = (List<Review>) reviewService.findAllByCarService(carServiceId);
        return reviews;
    }
}
