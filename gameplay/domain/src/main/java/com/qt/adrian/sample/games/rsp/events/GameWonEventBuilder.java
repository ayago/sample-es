package com.qt.adrian.sample.games.rsp.events;

import com.qt.adrian.sample.commons.EventBuilder;
import org.json.JSONObject;

public class GameWonEventBuilder extends EventBuilder<GameWonEventBuilder> {

    private String winnerEmail;
    private String loserEmail;

    private GameWonEventBuilder(){
        super(GameWonEventBuilder.class);
    }

    public static GameWonEventBuilder newInstance(){
        return new GameWonEventBuilder();
    }

    public GameWonEventBuilder setWinnerEmail(String winnerEmail) {
        this.winnerEmail = winnerEmail;
        return this;
    }

    public GameWonEventBuilder setLoserEmail(String loserEmail) {
        this.loserEmail = loserEmail;
        return this;
    }

    @Override
    protected String getPayload() {
        return new JSONObject()
                .put("winnerEmail", winnerEmail)
                .put("loserEmail", loserEmail)
                .toString();
    }
}
