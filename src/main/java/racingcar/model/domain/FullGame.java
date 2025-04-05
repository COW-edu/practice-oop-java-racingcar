package racingcar.model.domain;

public class FullGame {

    public static final int START_ROUND = 1;
    private final AllRacingCars allRacingCars;
    private final int gameCount;

    public FullGame(AllRacingCars allRacingCars, int gameCount) {
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
}
