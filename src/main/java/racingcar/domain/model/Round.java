package racingcar.domain.model;

public class Round {
    private final RacingCars racingCars;

    private Round(RacingCars racingCars) {
        this.racingCars = racingCars;
    }

    public static Round createRound(RacingCars racingCars) {
        return new Round(racingCars);
    }

    public void play() {
        racingCars.moveAll();
    }

    public RacingCars getRoundResult() {
        return racingCars;
    }


}
