package com.qt.adrian.sample.sg.venue.aggregates;

import com.qt.adrian.sample.commons.Aggregate;
import com.qt.adrian.sample.sg.venue.entities.Event;
import com.qt.adrian.sample.sg.venue.entities.EventId;
import com.qt.adrian.sample.sg.venue.vo.Admission;
import com.qt.adrian.sample.sg.venue.vo.Theme;
import com.qt.adrian.sample.sg.venue.vo.TimeSlots;
import com.qt.adrian.sample.sg.venue.vo.Type;
import com.qt.adrian.sample.sg.venue.entities.Venue;
import com.qt.adrian.sample.sg.venue.entities.VenueId;

import java.time.LocalDate;

public class InHouseEvents extends Aggregate<Event> {

    private VenueId venue;
    private TimeSlots timeSlots;
    private Admission admission;

    private InHouseEvents(Event event) {
        super(event);
    }

    public static Builder newBuilder(){
        return new Builder();
    }

    //events: InHouseEventUpdatedEvemt
    public InHouseEvents updateEvent(Venue venue, String name, Theme theme){
        Event event = this.getAggregateRoot();
        event.setName(name).setType(Type.IN_HOUSE).setTheme(theme);
        return this;
    }


    public static class Builder {
        private LocalDate localDate;
        private Venue venue;
        private Admission admission;
        private TimeSlots timeSlots;
        private Theme theme;
        private String name;

        private Builder() {}

        public Builder setLocalDate(LocalDate localDate) {
            this.localDate = localDate;
            return this;
        }

        public Builder setVenue(Venue venue) {
            this.venue = venue;
            return this;
        }

        public Builder setAdmission(Admission admission) {
            this.admission = admission;
            return this;
        }

        public Builder setTimeSlots(TimeSlots timeSlots) {
            this.timeSlots = timeSlots;
            return this;
        }

        public Builder setTheme(Theme theme) {
            this.theme = theme;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public InHouseEvents build(){
            Event event = new Event(new EventId(localDate.toString()))
                    .setName(name).setType(Type.IN_HOUSE).setTheme(theme);
            InHouseEvents eventAggregate = new InHouseEvents(event);
            eventAggregate.timeSlots = this.timeSlots;
            eventAggregate.admission = this.admission;
            return eventAggregate;
        }
    }
}
