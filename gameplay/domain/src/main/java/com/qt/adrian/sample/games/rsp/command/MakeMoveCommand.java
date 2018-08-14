package com.qt.adrian.sample.games.rsp.command;

import com.qt.adrian.sample.commons.Command;

public class MakeMoveCommand implements Command {

    private final String gameId;
    private final String playerEmail;
    private final Move move;

    private MakeMoveCommand(final Builder builder) {
        this.gameId = builder.gameId;
        this.playerEmail = builder.playerEmail;
        this.move = builder.move;
    }

    private static class Builder {
        private String gameId;
        private String playerEmail;
        private Move move;

        public Builder setGameId(String gameId) {
            this.gameId = gameId;
            return this;
        }

        public Builder setPlayerEmail(String playerEmail) {
            this.playerEmail = playerEmail;
            return this;
        }

        public Builder setMove(Move move) {
            this.move = move;
            return this;
        }

        public MakeMoveCommand build() {
            return new MakeMoveCommand(this);
        }
    }

    public String getGameId() {
        return gameId;
    }

    public String getPlayerEmail() {
        return playerEmail;
    }

    public Move getMove() {
        return move;
    }
}
