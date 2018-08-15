package com.qt.adrian.sample.sg.venue.entities;

import com.qt.adrian.sample.commons.Entity;
import com.qt.adrian.sample.sg.venue.vo.Theme;
import com.qt.adrian.sample.sg.venue.vo.Type;

public class Event extends Entity<EventId> {

    private String name;

    private Theme theme;

    private Type type;

    public Event(EventId id) {
        super(id);
    }

    public String getName() {
        return name;
    }

    public Event setName(String name) {
        this.name = name;
        return this;
    }

    public Theme getTheme() {
        return theme;
    }

    public Event setTheme(Theme theme) {
        this.theme = theme;
        return this;
    }

    public Type getType() {
        return type;
    }

    public Event setType(Type type) {
        this.type = type;
        return this;
    }
}
