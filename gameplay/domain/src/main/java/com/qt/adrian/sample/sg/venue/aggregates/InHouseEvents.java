package com.qt.adrian.sample.sg.venue.aggregates;

import com.qt.adrian.sample.commons.Event;
import com.qt.adrian.sample.commons.EventPublisher;
import com.qt.adrian.sample.commons.EventuallyConsistentAggregate;
import com.qt.adrian.sample.sg.venue.aggregates.commands.UpdateInHouseEventCommand;
import com.qt.adrian.sample.sg.venue.aggregates.events.InHouseEventUpdatedEventBuilder;
import com.qt.adrian.sample.sg.venue.entities.VenueEvent;
import com.qt.adrian.sample.sg.venue.entities.EventId;
import com.qt.adrian.sample.sg.venue.vo.*;
import com.qt.adrian.sample.sg.venue.entities.Venue;

import java.time.LocalDate;

public class InHouseEvents extends EventuallyConsistentAggregate<VenueEvent> {

    private InHouseEvents(VenueEvent venueEvent, EventPublisher eventPublisher) {
        super(venueEvent, eventPublisher);
    }

    public static Builder newBuilder(EventPublisher eventPublisher){
        return new Builder(eventPublisher);
    }

    //events: InHouseEventUpdatedEvent
    public RecordedEvents updateEvent(UpdateInHouseEventCommand command){
        this.getAggregateRoot().setName(command.getName()).setTheme(command.getTheme());

        Event event = InHouseEventUpdatedEventBuilder.newInstance()
                .setAggregateId(getAggregateRoot().getId())
                .setAdmission(command.getAdmission())
                .setName(command.getName())
                .setTimeSlots(command.getTimeSlots())
                .build();

        getEventPublisher().publishEvents(event);

        return new RecordedEvents(this.getAggregateRoot(), EventStatus.DRAFT);
    }

    public static class Builder {
        private LocalDate localDate;
        private Theme theme;
        private String name;
        private final EventPublisher eventPublisher;

        private Builder(EventPublisher eventPublisher) {
            this.eventPublisher = eventPublisher;
        }

        public Builder setLocalDate(LocalDate localDate) {
            this.localDate = localDate;
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
            VenueEvent venueEvent = new VenueEvent(new EventId(localDate.toString()))
                    .setName(name).setType(Type.IN_HOUSE).setTheme(theme);
            return new InHouseEvents(venueEvent, eventPublisher);
        }
    }
}
