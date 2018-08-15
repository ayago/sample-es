package com.qt.adrian.sample.sg.venue.aggregates.commands;

import com.qt.adrian.sample.sg.venue.vo.Admission;
import com.qt.adrian.sample.sg.venue.vo.Theme;
import com.qt.adrian.sample.sg.venue.vo.TimeSlot;
import com.qt.adrian.sample.sg.venue.vo.TimeSlots;

import java.time.LocalTime;
import java.util.List;


public class UpdateInHouseEventCommand {
    
    private final Theme theme;
    private final String name;
    private final TimeSlots timeSlots;
    private final Admission admission;
    
    private UpdateInHouseEventCommand(final Builder builder) {
        this.theme = builder.theme;
        this.admission = builder.admission;
        this.timeSlots = builder.getTimeSlots();
        this.name = builder.name;
    }
    
    public static class Builder {
        private String name;
        private Theme theme;
        private List<TimeSlot> timeSlots;
        private Admission admission;

        private Builder(){}

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setTheme(Theme theme) {
            this.theme = theme;
            return this;
        }
        
        public Builder addTimeSlot(LocalTime start, LocalTime end) {
            this.timeSlots.add(new TimeSlot(start, end));
            return this;
        }

        public Builder setAdmission(Admission admission) {
            this.admission = admission;
            return this;
        }

        public UpdateInHouseEventCommand build(){
            return new UpdateInHouseEventCommand(this);
        }

        private TimeSlots getTimeSlots(){
            return new TimeSlots(timeSlots);
        }
    }

    public Theme getTheme() {
        return theme;
    }

    public String getName() {
        return name;
    }

    public TimeSlots getTimeSlots() {
        return timeSlots;
    }

    public Admission getAdmission() {
        return admission;
    }
}
