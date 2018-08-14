package com.qt.adrian.sample.games.rsp.events;

import com.qt.adrian.sample.commons.EventBuilder;

public class GameTiedEventBuilder extends EventBuilder<GameTiedEventBuilder> {

    private GameTiedEventBuilder(){
        super(GameTiedEventBuilder.class);
    }

    public static GameTiedEventBuilder newInstance(){
        return new GameTiedEventBuilder();
    }

    @Override
    protected String getPayload() {
        return null;
    }
}
