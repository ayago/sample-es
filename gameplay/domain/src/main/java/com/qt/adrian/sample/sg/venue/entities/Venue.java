package com.qt.adrian.sample.sg.venue.entities;

import com.qt.adrian.sample.commons.Entity;

public class Venue extends Entity<VenueId> {

    private String name;

    public Venue(VenueId id) {
        super(id);
    }
}
