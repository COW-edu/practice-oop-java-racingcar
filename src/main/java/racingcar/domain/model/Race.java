package racingcar.domain.model;

import java.util.List;

public class Race {

    private final RacingCars racingCars;
    private final Round round;

    public Race(RacingCars racingCars, Round round) {
        this.racingCars = racingCars;
        this.round = round;
    }

    public RacingCars startRace(int tryingNumber) {
        for (int i = 0; i < tryingNumber; i++) {
            Round.createRound(racingCars).play();
        }
        return racingCars;
        //최종 결과 출력할 때 필요.
    }

    public List<RacingCar> compare() {
        return racingCars.getRacingCars().stream().filter(car -> car.getPosition() == getWinningPosition()).toList();
    }

    private int getWinningPosition() {
        return racingCars.getRacingCars()
                .stream()
                .mapToInt(RacingCar::getPosition)
                .max()
                .orElseThrow(() -> new IllegalArgumentException("차량이 없습니다."));
    }
}
