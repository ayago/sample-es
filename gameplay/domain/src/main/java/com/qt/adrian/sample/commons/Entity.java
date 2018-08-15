package com.qt.adrian.sample.commons;

public abstract class Entity<ID extends EntityId<?>> {

    private final ID id;

    protected Entity(ID id) {
        this.id = id;
    }

    public final ID getId(){
        return id;
    }
}
