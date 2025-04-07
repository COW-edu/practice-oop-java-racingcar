package racingcar.application;

import racingcar.common.config.RacingGameConfig;
import racingcar.domain.RacingGame;

public class RacingGameFacade {

    private final GameSetUp gameSetUp;
    private final GameExecutor gameExecutor;

    public RacingGameFacade(
            GameSetUp gameSetUp,
            GameExecutor gameExecutor
    ) {
        this.gameSetUp = gameSetUp;
        this.gameExecutor = gameExecutor;
    }

    public void playGame() {
        RacingGameConfig config = gameSetUp.createRacingGameConfig();
        RacingGame racingGame = new RacingGame(config);
        gameExecutor.executeGame(racingGame);
        gameExecutor.announceWinner(racingGame);
    }
}
