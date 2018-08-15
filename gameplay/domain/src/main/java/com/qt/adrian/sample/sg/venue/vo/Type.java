package com.qt.adrian.sample.sg.venue.vo;

public enum Type {
    IN_HOUSE("In House"), PRODUCTION("Production");

    private String readableName;

    Type(String readableName) {
        this.readableName = readableName;
    }

    public String getReadableName() {
        return readableName;
    }
}
