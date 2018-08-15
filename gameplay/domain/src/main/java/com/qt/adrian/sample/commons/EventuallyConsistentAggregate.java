package com.qt.adrian.sample.commons;

public abstract class EventuallyConsistentAggregate<AGGREGATE_ROOT extends Entity<?>> extends Aggregate<AGGREGATE_ROOT>{

    private final EventPublisher eventPublisher;

    protected EventuallyConsistentAggregate(AGGREGATE_ROOT aggregate_root, EventPublisher eventPublisher) {
        super(aggregate_root);
        this.eventPublisher = eventPublisher;
    }

    protected final EventPublisher getEventPublisher() {
        return eventPublisher;
    }
}
