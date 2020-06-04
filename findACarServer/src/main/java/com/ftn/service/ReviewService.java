package com.ftn.service;

import com.ftn.model.Review;
import com.ftn.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ReviewService {

    private ReviewRepository reviewRepository;

    @Autowired
    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public Collection<Review> findAllByCarService(Long carServiceId){
        return reviewRepository.findAllByCarServiceId(carServiceId);
    }

}
