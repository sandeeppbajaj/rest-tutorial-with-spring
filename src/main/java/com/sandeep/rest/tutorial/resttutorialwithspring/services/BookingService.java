package com.sandeep.rest.tutorial.resttutorialwithspring.services;

import com.sandeep.rest.tutorial.resttutorialwithspring.models.Booking;
import com.sandeep.rest.tutorial.resttutorialwithspring.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    public Booking saveBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    public Collection<Booking> findByAccountUsername(String userId) {
        return this.bookingRepository.findByAccountUsername(userId);
    }

    public Booking findById(Long bookingId) {
        return this.bookingRepository.findOne(bookingId);
    }
}
