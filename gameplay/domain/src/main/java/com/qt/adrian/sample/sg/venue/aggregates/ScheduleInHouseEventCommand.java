package com.qt.adrian.sample.sg.venue.aggregates;

import com.qt.adrian.sample.sg.venue.vo.Admission;
import com.qt.adrian.sample.sg.venue.vo.Theme;
import com.qt.adrian.sample.sg.venue.vo.TimeSlot;
import com.qt.adrian.sample.sg.venue.vo.TimeSlots;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class ScheduleInHouseEventCommand {
    
    private final String name;
    private final Theme theme;
    private final LocalDate date;
    private final TimeSlots timeSlots;
    private final Admission admission;

    private ScheduleInHouseEventCommand(final Builder builder) {
        this.name = builder.name;
        this.theme = builder.theme;
        this.date = builder.date;
        this.timeSlots = builder.getTimeSlots();
        this.admission = builder.admission;
    }

    public static Builder newBuilder(){
        return new Builder();
    }
    
    public static class Builder {
        private String name;
        private Theme theme;
        private LocalDate date;
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

        public Builder setDate(LocalDate date) {
            this.date = date;
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

        public ScheduleInHouseEventCommand build(){
            return new ScheduleInHouseEventCommand(this);
        }

        private TimeSlots getTimeSlots(){
            return new TimeSlots(timeSlots);
        }
    }

    public String getName() {
        return name;
    }

    public Theme getTheme() {
        return theme;
    }

    public LocalDate getDate() {
        return date;
    }

    public TimeSlots getTimeSlots() {
        return timeSlots;
    }

    public Admission getAdmission() {
        return admission;
    }
}
