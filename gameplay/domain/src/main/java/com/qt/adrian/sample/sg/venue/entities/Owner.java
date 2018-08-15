package com.qt.adrian.sample.sg.venue.entities;

import com.qt.adrian.sample.commons.Entity;

public class Owner extends Entity<OwnerId> {

    private String firstName;

    private String lastName;

    public Owner(OwnerId id) {
        super(id);
    }

    public String getFirstName() {
        return firstName;
    }

    public Owner setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public Owner setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

}
