package com.ftn.controller;

import com.ftn.model.CarService;
import com.ftn.model.Review;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/carservices")
public class CarServiceController {

    // private CarServiceService carServiceService;

    @GetMapping("/{carServiceId}/reviews")
    public ResponseEntity<List<Review>> getReviews(@PathVariable Long carServiceId){
        return null;
    }
}
