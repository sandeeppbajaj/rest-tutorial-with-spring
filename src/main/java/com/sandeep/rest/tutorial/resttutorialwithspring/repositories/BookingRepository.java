package com.sandeep.rest.tutorial.resttutorialwithspring.repositories;

import com.sandeep.rest.tutorial.resttutorialwithspring.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface BookingRepository extends JpaRepository<Booking, Long>{
    Collection<Booking> findByAccountUsername(String username);
}
