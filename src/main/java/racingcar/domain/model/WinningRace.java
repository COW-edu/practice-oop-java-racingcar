package racingcar.domain.model;

import java.util.List;

public class WinningRace {
    private final RacingCars racingCars;

    public WinningRace(RacingCars racingCars) {
        this.racingCars = racingCars;
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
