package com.qt.adrian.sample.commons;

public interface EventuallyConsistentAggregateFactory<
        FACTORY_ARGS, AGGREGATE extends EventuallyConsistentAggregate<?>> {

    default AGGREGATE create(FACTORY_ARGS propertiesBuilder, EventPublisher eventPublisher) {
        throw new UnsupportedOperationException("Method not supported");
    }

    default AGGREGATE create(EventPublisher eventPublisher) {
        throw new UnsupportedOperationException("Method not supported");
    }
}
