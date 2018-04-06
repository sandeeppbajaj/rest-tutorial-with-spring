package com.sandeep.rest.tutorial.resttutorialwithspring.advices;

import com.sandeep.rest.tutorial.resttutorialwithspring.exceptions.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

//@ControllerAdvice
class BookingControllerAdvice {

    @ResponseBody
    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    UserNotFoundException userNotFoundExceptionHandler(UserNotFoundException ex) {
        return new UserNotFoundException(ex.getMessage());
    }
}
