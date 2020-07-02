package com.ftn.repository;

import com.ftn.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ftn.model.Reservation;

import java.util.Date;
import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    List<Reservation> findAllByPickupNotificationSentIsFalseOrReturnNotificationSentIsFalse();
    List<Reservation> findAllByUserEmail(String email);
    List<Reservation> findAllByUserEmailAndReturnDateLessThan(String email, Date date);
}
