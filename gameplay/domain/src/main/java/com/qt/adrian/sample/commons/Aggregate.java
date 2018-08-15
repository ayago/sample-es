package com.qt.adrian.sample.commons;

public abstract class Aggregate<AGGREGATE_ROOT extends Entity<?>> {


    private final AGGREGATE_ROOT root;

    protected Aggregate(AGGREGATE_ROOT root) {
        this.root = root;
    }

    public final AGGREGATE_ROOT getAggregateRoot() {
        return root;
    }
}
