package com.qt.adrian.sample.sg.venue.aggregates;

import com.qt.adrian.sample.commons.Event;
import com.qt.adrian.sample.commons.EventPublisher;
import com.qt.adrian.sample.commons.EventuallyConsistentAggregate;
import com.qt.adrian.sample.sg.venue.aggregates.commands.ScheduleInHouseEventCommand;
import com.qt.adrian.sample.sg.venue.aggregates.events.InHouseEventScheduledEventBuilder;
import com.qt.adrian.sample.sg.venue.entities.VenueEvent;
import com.qt.adrian.sample.sg.venue.entities.EventId;
import com.qt.adrian.sample.sg.venue.entities.Venue;
import com.qt.adrian.sample.sg.venue.vo.EventStatus;
import com.qt.adrian.sample.sg.venue.vo.Type;

public class VenueCalendar extends EventuallyConsistentAggregate<Venue> {

    private VenueCalendar(
            Venue venue, EventPublisher eventPublisher) {
        super(venue, eventPublisher);
    }

    public static VenueCalendar createInstance(Venue venue, EventPublisher eventPublisher){
        return new VenueCalendar(venue, eventPublisher);
    }

    //events created: InHouseEventScheduled
    public RecordedEvents scheduleInHouseEvent(ScheduleInHouseEventCommand command){

        VenueEvent venueEvent = new VenueEvent(new EventId(command.getDate().toString()))
                .setName(command.getName()).setType(Type.IN_HOUSE).setTheme(command.getTheme());

        Event event = InHouseEventScheduledEventBuilder.newInstance()
                .setAggregateId(venueEvent.getId())
                .setAdmission(command.getAdmission())
                .setName(command.getName())
                .setTimeSlots(command.getTimeSlots())
                .setVenue(this.getAggregateRoot().getId())
                .setEventDate(command.getDate())
                .build();

        this.getEventPublisher().publishEvents(event);

        return new RecordedEvents(venueEvent, EventStatus.DRAFT);
    }


}
