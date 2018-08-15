package com.qt.adrian.sample.sg.venue.aggregates;

import com.qt.adrian.sample.commons.Aggregate;
import com.qt.adrian.sample.sg.venue.entities.VenueEvent;
import com.qt.adrian.sample.sg.venue.vo.EventStatus;
import com.qt.adrian.sample.sg.venue.vo.Type;

public class RecordedEvents extends Aggregate<VenueEvent> {

    private EventStatus status;

    public RecordedEvents(VenueEvent venueEvent, EventStatus status) {
        super(venueEvent);
        this.status = status;
    }

    public String getName() {
        return getAggregateRoot().getName();
    }

    public EventStatus status() {
        return status;
    }

    public Type getType() {
        return getAggregateRoot().getType();
    }
}
