package racingcar.domain.model;

import java.util.List;
import java.util.stream.Collectors;

public class Race {

    private final RacingCars racingCars;

    public Race(RacingCars racingCars) {
        this.racingCars = racingCars;
    }

    public void startRace() {
        for (RacingCar racingCar : racingCars.getRacingCars()) {
            racingCar.move();
        }
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
