package racingcar.model.domain;

public class FullGame {

    private final AllRacingCars allRacingCars;
    private final int gameCount;

    public FullGame(AllRacingCars allRacingCars, int gameCount) {
        this.allRacingCars = allRacingCars;
        this.gameCount = gameCount;
    }

    public GameRecords startGame() {
        Game game = new Game();
        GameRecords gameRecords = new GameRecords();
        for (int round = 0; round < gameCount; round++) {
            allRacingCars.playOneRound(gameRecords, round, game);
        }
        return gameRecords;
    }
}
