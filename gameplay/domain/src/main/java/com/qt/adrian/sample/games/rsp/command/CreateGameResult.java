package com.qt.adrian.sample.games.rsp.command;

public class CreateGameResult {
    private final String gameId;
    private final String createdBy;

    public CreateGameResult(String gameId, String createdBy) {
        this.gameId = gameId;
        this.createdBy = createdBy;
    }

    public String getGameId() {
        return gameId;
    }

    public String getCreatedBy() {
        return createdBy;
    }
}
