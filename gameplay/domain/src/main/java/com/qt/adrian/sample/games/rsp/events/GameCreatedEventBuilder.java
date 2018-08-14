package com.qt.adrian.sample.games.rsp.events;

import com.qt.adrian.sample.commons.EventBuilder;
import org.json.JSONObject;

public class GameCreatedEventBuilder extends EventBuilder<GameCreatedEventBuilder> {

    private String playerEmail;

    private GameCreatedEventBuilder() {
        super(GameCreatedEventBuilder.class);
    }

    public static GameCreatedEventBuilder newInstance() {
        return new GameCreatedEventBuilder();
    }

    public GameCreatedEventBuilder setPlayerEmail(String playerEmail) {
        this.playerEmail = playerEmail;
        return this;
    }

    @Override
    protected String getPayload() {
        return new JSONObject().put("playerEmail", playerEmail).toString();
    }

}
