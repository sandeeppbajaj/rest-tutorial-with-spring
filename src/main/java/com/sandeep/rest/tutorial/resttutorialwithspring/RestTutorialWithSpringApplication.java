package com.sandeep.rest.tutorial.resttutorialwithspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class RestTutorialWithSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestTutorialWithSpringApplication.class, args);
    }
}
