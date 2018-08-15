package com.qt.adrian.sample.sg.venue.aggregates.events;

import com.qt.adrian.sample.commons.EventBuilder;
import com.qt.adrian.sample.sg.venue.entities.EventId;
import com.qt.adrian.sample.sg.venue.vo.Admission;
import com.qt.adrian.sample.sg.venue.vo.TimeSlots;


public class InHouseEventUpdatedEventBuilder extends EventBuilder<InHouseEventUpdatedEventBuilder, EventId> {

    private String name;
    private Admission admission;
    private TimeSlots timeSlots;

    public static InHouseEventUpdatedEventBuilder newInstance(){
        return new InHouseEventUpdatedEventBuilder();
    }

    private InHouseEventUpdatedEventBuilder() {
        super(InHouseEventUpdatedEventBuilder.class);
    }

    public InHouseEventUpdatedEventBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public InHouseEventUpdatedEventBuilder setAdmission(Admission admission) {
        this.admission = admission;
        return this;
    }

    public InHouseEventUpdatedEventBuilder setTimeSlots(TimeSlots timeSlots) {
        this.timeSlots = timeSlots;
        return this;
    }

    @Override
    protected String getPayload() {
        throw new UnsupportedOperationException("InHouseEventUpdatedEventBuilder payload not yet supported");
    }
}
