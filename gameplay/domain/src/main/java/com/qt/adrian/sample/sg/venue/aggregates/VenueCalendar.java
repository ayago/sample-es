package com.qt.adrian.sample.sg.venue.aggregates;

import com.qt.adrian.sample.commons.Aggregate;
import com.qt.adrian.sample.sg.venue.vo.Theme;
import com.qt.adrian.sample.sg.venue.entities.Venue;

import java.time.LocalDateTime;

public class VenueCalendar extends Aggregate<Venue> {

    private VenueCalendar(Venue venue) {
        super(venue);
    }

    public static VenueCalendar createInstance(Venue venue){
        return new VenueCalendar(venue);
    }

    //events created: InHouseEventScheduled
    public InHouseEvents scheduleEvent(ScheduleInHouseEventCommand command){
        InHouseEvents inHouseEvents = InHouseEvents.newBuilder()
                .setAdmission(command.getAdmission())
                .setLocalDate(command.getDate())
                .setName(command.getName())
                .setTheme(command.getTheme())
                .setVenue(this.getAggregateRoot())
                .setTimeSlots(command.getTimeSlots())
                .build();


        return inHouseEvents;
    }


}
