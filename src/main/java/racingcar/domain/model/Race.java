package racingcar.domain.model;

import java.util.List;

public class Race {

    private final RacingCars racingCars;

    public Race(RacingCars racingCars) {
        this.racingCars = racingCars;
    }

    public RacingCars startRace(int tryingNumber) {
        for (int i = 0; i < tryingNumber; i++) {
            racingCars.getRacingCars().forEach(RacingCar::move);
        }
        return racingCars;
        //결과 출력할 때 필요.
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
