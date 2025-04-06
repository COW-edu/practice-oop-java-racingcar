package racingcar.model.domain;

import java.util.HashMap;
import java.util.Map;
import racingcar.common.ErrorMessage;

public final class FullGame {

    public static final int START_ROUND = 1;
    public static final int MIN_GAME_COUNT = 0;

    private final AllRacingCars allRacingCars;
    private final int gameCount;

    public FullGame(AllRacingCars allRacingCars, int gameCount) {
        validate(gameCount);
        this.allRacingCars = allRacingCars;
        this.gameCount = gameCount;
    }

    public GameRecords playAllRounds() {
        Map<Integer, Round> gameResult = new HashMap<>();
        for (int roundCount = START_ROUND; roundCount <= gameCount; roundCount++) {
            Round round = allRacingCars.playOneRound();
            gameResult.put(roundCount, round);
        }
        return new GameRecords(gameResult);
    }

    private void validate(int gameCount) {
        if (gameCount <= MIN_GAME_COUNT) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_TOO_SMALL_GAME_COUNT);
        }
    }
}
