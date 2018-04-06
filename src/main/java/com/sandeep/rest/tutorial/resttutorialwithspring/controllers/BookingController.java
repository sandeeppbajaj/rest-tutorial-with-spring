package com.sandeep.rest.tutorial.resttutorialwithspring.controllers;

import com.sandeep.rest.tutorial.resttutorialwithspring.models.Booking;
import com.sandeep.rest.tutorial.resttutorialwithspring.repositories.AccountRepository;
import com.sandeep.rest.tutorial.resttutorialwithspring.services.BookingService;
import com.sandeep.rest.tutorial.resttutorialwithspring.utilities.ValidationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping(value="/{userId}/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private ValidationUtil validationUtil;

    @RequestMapping(method = RequestMethod.GET)
    Collection<Booking> readBookings(@PathVariable String userId) {
        validationUtil.validateUser(userId);
        return this.bookingService.findByAccountUsername(userId);
    }

    @RequestMapping(method = RequestMethod.POST)
    ResponseEntity<?> add(@PathVariable String userId, @RequestBody Booking input) {
        validationUtil.validateUser(userId);

        return this.accountRepository
                .findByUsername(userId)
                .map(account -> {
                    Booking result = bookingService.saveBooking(new Booking(account,
                            input.getUri(), input.getDescription()));

                    URI location = ServletUriComponentsBuilder
                            .fromCurrentRequest().path("/{id}")
                            .buildAndExpand(result.getId()).toUri();

                    return ResponseEntity.created(location).build();
                })
                .orElse(ResponseEntity.noContent().build());

    }

    @RequestMapping(method = RequestMethod.GET, value = "/{bookingId}")
    Booking readBooking(@PathVariable String userId, @PathVariable Long bookingId) {
        validationUtil.validateUser(userId);
        return this.bookingService.findById(bookingId);
    }
}
