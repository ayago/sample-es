package com.qt.adrian.sample.sg.venue.aggregates.events;

import com.qt.adrian.sample.commons.EventBuilder;
import com.qt.adrian.sample.sg.venue.entities.EventId;
import com.qt.adrian.sample.sg.venue.entities.VenueId;
import com.qt.adrian.sample.sg.venue.vo.Admission;
import com.qt.adrian.sample.sg.venue.vo.TimeSlots;

import java.time.LocalDate;

public class InHouseEventScheduledEventBuilder extends EventBuilder<InHouseEventScheduledEventBuilder, EventId> {

    private String name;
    private VenueId venue;
    private LocalDate eventDate;
    private Admission admission;
    private TimeSlots timeSlots;

    public static InHouseEventScheduledEventBuilder newInstance(){
        return new InHouseEventScheduledEventBuilder();
    }

    private InHouseEventScheduledEventBuilder() {
        super(InHouseEventScheduledEventBuilder.class);
    }

    public InHouseEventScheduledEventBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public InHouseEventScheduledEventBuilder setVenue(VenueId venue) {
        this.venue = venue;
        return this;
    }

    public InHouseEventScheduledEventBuilder setEventDate(LocalDate eventDate) {
        this.eventDate = eventDate;
        return this;
    }

    public InHouseEventScheduledEventBuilder setAdmission(Admission admission) {
        this.admission = admission;
        return this;
    }

    public InHouseEventScheduledEventBuilder setTimeSlots(TimeSlots timeSlots) {
        this.timeSlots = timeSlots;
        return this;
    }

    @Override
    protected String getPayload() {
        throw new UnsupportedOperationException("InHouseEventScheduledEventBuilder payload not yet supported");
    }
}
