package com.qt.adrian.sample.games.rsp.command;

import com.qt.adrian.sample.commons.Command;

public class CreateGameCommand implements Command {

    private final String gameId;
    private final String createdBy;

    private CreateGameCommand(String gameId, String createdBy) {
        this.createdBy = createdBy;
        this.gameId = gameId;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public String getGameId() {
        return gameId;
    }
}
