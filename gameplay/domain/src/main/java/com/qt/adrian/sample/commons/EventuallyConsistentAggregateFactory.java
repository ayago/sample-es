package com.qt.adrian.sample.commons;

public interface EventuallyConsistentAggregateFactory<
        PROP_BUILDER, AGGREGATE extends EventuallyConsistentAggregate<?>> {

    AGGREGATE create(PROP_BUILDER propertiesBuilder, EventPublisher eventPublisher);
}
