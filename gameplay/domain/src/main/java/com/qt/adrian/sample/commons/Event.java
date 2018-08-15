package com.qt.adrian.sample.commons;


import java.time.ZonedDateTime;
import java.util.Objects;

public final class Event {

    private final String aggregateId;

    private final long timeStamp;

    private final String payload;

    private final String aggregateName;

    private final String author;

    Event(final EventBuilder builder) {
        this.aggregateId = Objects.requireNonNull(
                builder.getAggregateId(), "Aggregate Id required").stringValue();
        this.payload = builder.getPayload();
        this.aggregateName = Objects.requireNonNull(
                builder.getAggregateName(), "Aggregate name required");
        this.author = Objects.requireNonNull(
                builder.getAuthor(), "Author required");
        this.timeStamp = ZonedDateTime.now().toInstant().toEpochMilli();
    }

    public String getAggregateId() {
        return aggregateId;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public String getPayload() {
        return payload;
    }

    public String getAggregateName() {
        return aggregateName;
    }

    public String getAuthor() {
        return author;
    }
}
