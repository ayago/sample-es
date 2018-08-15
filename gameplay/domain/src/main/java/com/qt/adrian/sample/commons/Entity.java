package com.qt.adrian.sample.commons;

import java.util.Objects;

public abstract class Entity<ID extends EntityId<?>> {

    private final ID id;

    protected Entity(ID id) {
        this.id = Objects.requireNonNull(id, "entity id required");
    }

    public final ID getId(){
        return id;
    }
}
