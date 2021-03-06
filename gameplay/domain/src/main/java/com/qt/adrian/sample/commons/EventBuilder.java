package com.qt.adrian.sample.commons;

import java.util.Objects;

public abstract class EventBuilder <C extends EventBuilder<C>> {

    private String author;

    private String aggregateId;

    private final Class<C> clazz;

    protected EventBuilder(final Class<C> clazz){
        this.clazz  = Objects.requireNonNull(clazz, "Builder subtype required");
    }

    String getAggregateId() {
        return aggregateId;
    }

    protected abstract String getPayload();

    String getAggregateName() {
        return clazz.getSimpleName().replace("Builder", "");
    }

    String getAuthor() {
        return author;
    }

    public C setAuthor(String author) {
        this.author = author;
        return clazz.cast(this);
    }

    public C setAggregateId(String aggregateId) {
        this.aggregateId = aggregateId;
        return clazz.cast(this);
    }

    public final Event build(){
        return new Event(this);
    }
}
