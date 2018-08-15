package com.qt.adrian.sample.commons;

import java.util.Objects;

public abstract class Aggregate<AGGREGATE_ROOT extends Entity<?>> {


    private final AGGREGATE_ROOT root;

    protected Aggregate(AGGREGATE_ROOT root) {
        this.root = Objects.requireNonNull(root, "aggregate root is required");
    }

    public final AGGREGATE_ROOT getAggregateRoot() {
        return root;
    }
}
