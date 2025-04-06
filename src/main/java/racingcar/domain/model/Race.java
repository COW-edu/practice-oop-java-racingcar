package racingcar.domain.model;

import java.util.List;

public class Race {

    private final RacingCars racingCars;
    private final Round round;

    public Race(RacingCars racingCars, Round round) {
        this.racingCars = racingCars;
        this.round = round;
    }

    public void startRace(int tryingNumber) {
        for (int i = 0; i < tryingNumber; i++) {
            Round.createRound(racingCars).play();
        }
    }


}
