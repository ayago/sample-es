package com.qt.adrian.sample.games.rsp.command;

public enum Move {
    ROCK, SCISSORS, PAPER;

    public boolean defeats(Move other) {
        switch (this) {
            case ROCK:
                return other == SCISSORS;
            case PAPER:
                return other == ROCK;
            case SCISSORS:
                return other == PAPER;
        }
        return false;
    }
}
