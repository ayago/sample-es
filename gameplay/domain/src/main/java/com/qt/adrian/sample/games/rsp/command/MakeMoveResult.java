package com.qt.adrian.sample.games.rsp.command;

public class MakeMoveResult {

    private final String gameId;

    private final String playerOneEmail;

    private final String playerTwoEmail;


    public MakeMoveResult(String gameId, String playerOneEmail, String playerTwoEmail) {
        this.gameId = gameId;
        this.playerOneEmail = playerOneEmail;
        this.playerTwoEmail = playerTwoEmail;
    }

    public String getGameId() {
        return gameId;
    }

    public String getPlayerOneEmail() {
        return playerOneEmail;
    }

    public String getPlayerTwoEmail() {
        return playerTwoEmail;
    }
}
