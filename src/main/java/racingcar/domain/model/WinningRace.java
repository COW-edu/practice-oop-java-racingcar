package racingcar.domain.model;

import java.util.List;
import java.util.stream.Collectors;

public class WinningRace {
    private final RacingCars racingCars;

    public WinningRace(RacingCars racingCars) {
        this.racingCars = racingCars;
    }

    public RacingCars compare() {
        return RacingCars.create(racingCars.getRacingCars()
                .stream()
                .filter(car -> car.getPosition() == getWinningPosition())
                .toList());
    }

    private int getWinningPosition() {
        return racingCars.getRacingCars()
                .stream()
                .mapToInt(RacingCar::getPosition)
                .max()
                .orElseThrow(() -> new IllegalArgumentException("차량이 없습니다."));
    }

}
