package com.ftn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ftn.model.Review;

import java.util.Collection;

@Repository
public interface ReviewRepository extends JpaRepository<Review,Long> {

    Collection<Review> findAllByCarServiceId(Long carServiceId);
}
