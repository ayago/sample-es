package com.qt.adrian.sample.games.rsp;

import com.qt.adrian.sample.commons.EventPublisher;
import com.qt.adrian.sample.games.rsp.command.CreateGameCommand;
import com.qt.adrian.sample.games.rsp.command.MakeMoveCommand;
import com.qt.adrian.sample.games.rsp.events.MoveDecidedEventBuilder;

public class Game {

    private final EventPublisher eventPublisher;

    private String gameId;
    private String playerOneEmail;
    private String playerTwoEmail;

    private Game(EventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    public static Game createNewGame(CreateGameCommand createGameCommand, EventPublisher eventPublisher) {
        Game game = new Game(eventPublisher);
        game.gameId = createGameCommand.getGameId();
        game.playerOneEmail = createGameCommand.getCreatedBy();
        return game;
    }

    public void acceptMove(MakeMoveCommand makeMoveCommand){
        String playerEmail = makeMoveCommand.getPlayerEmail();
        if(playerOneEmail.equals(playerEmail))
            playerTwoEmail = playerEmail;

        eventPublisher.publishEvents(
                MoveDecidedEventBuilder.newInstance()
                    .setMove(makeMoveCommand.getMove())
                    .setPlayerEmail(playerEmail)
                    .build()
        );
    }
}
