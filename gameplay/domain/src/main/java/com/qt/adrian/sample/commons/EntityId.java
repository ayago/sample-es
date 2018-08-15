package com.qt.adrian.sample.commons;

public abstract class EntityId<ID_TYPE>{

    private final ID_TYPE naturalValue;

    protected EntityId(ID_TYPE naturalValue) {
        this.naturalValue = naturalValue;
    }

    public final ID_TYPE getNaturalValue() {
        return naturalValue;
    }

    public String stringValue() {
        return naturalValue.toString();
    }
}
