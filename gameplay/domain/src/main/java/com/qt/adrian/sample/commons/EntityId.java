package com.qt.adrian.sample.commons;

import java.util.Objects;

public abstract class EntityId<ID_TYPE>{

    private final ID_TYPE naturalValue;

    protected EntityId(ID_TYPE naturalValue) {
        this.naturalValue = Objects.requireNonNull(naturalValue, "entity id natural value required");
    }

    public final ID_TYPE getNaturalValue() {
        return naturalValue;
    }

    public String stringValue() {
        return naturalValue.toString();
    }
}
