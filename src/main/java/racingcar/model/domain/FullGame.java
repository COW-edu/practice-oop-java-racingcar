package racingcar.model.domain;

import racingcar.common.ErrorMessage;

public class FullGame {

    public static final int START_ROUND = 1;

    private final AllRacingCars allRacingCars;
    private final int gameCount;

    public FullGame(AllRacingCars allRacingCars, int gameCount) {
        validate(gameCount);
        this.allRacingCars = allRacingCars;
        this.gameCount = gameCount;
    }

    public GameRecords startGame() {
        GameRecords gameRecords = new GameRecords();
        for (int round = START_ROUND; round <= gameCount; round++) {
            allRacingCars.playOneRound(gameRecords, round);
        }
        return gameRecords;
    }

    private void validate(int gameCount) {
        if (gameCount <= 0) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_TOO_SMALL_GAME_COUNT);
        }
    }
}
