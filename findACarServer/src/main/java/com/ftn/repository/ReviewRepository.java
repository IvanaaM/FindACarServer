package com.ftn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ftn.model.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review,Long> {

}
