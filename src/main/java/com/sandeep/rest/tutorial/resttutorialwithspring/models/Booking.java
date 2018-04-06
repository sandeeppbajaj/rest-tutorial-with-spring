package com.sandeep.rest.tutorial.resttutorialwithspring.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Entity
public class Booking implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    private String uri;
    private String description;

    @JsonIgnore
    @ManyToOne
    private Account account;

    public Booking(final Account account, String uri, String description) {
        this.account = account;
        this.uri = uri;
        this.description = description;
    }

    public Booking() {
    }

    public Long getId() {
        return id;
    }

    public Account getAccount() {
        return account;
    }

    public String getUri() {
        return uri;
    }

    public String getDescription() {
        return description;
    }
}
