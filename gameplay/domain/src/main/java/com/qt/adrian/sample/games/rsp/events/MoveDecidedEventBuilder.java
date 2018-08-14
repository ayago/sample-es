package com.qt.adrian.sample.games.rsp.events;

import com.qt.adrian.sample.commons.EventBuilder;
import com.qt.adrian.sample.games.rsp.command.Move;
import org.json.JSONObject;

public class MoveDecidedEventBuilder extends EventBuilder<MoveDecidedEventBuilder> {

    private String playerEmail;

    private Move move;

    private MoveDecidedEventBuilder() {
        super(MoveDecidedEventBuilder.class);
    }

    private MoveDecidedEventBuilder newInstance() {
        return new MoveDecidedEventBuilder();
    }

    public MoveDecidedEventBuilder setPlayerEmail(String playerEmail) {
        this.playerEmail = playerEmail;
        return this;
    }

    public MoveDecidedEventBuilder setMove(Move move) {
        this.move = move;
        return this;
    }

    @Override
    protected String getPayload() {
        return new JSONObject().put("playerEmail", playerEmail).put("move", move.name()).toString();
    }
}
