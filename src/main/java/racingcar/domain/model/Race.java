package racingcar.domain.model;

import racingcar.global.ErrorMessage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Race {

    private final RacingCars racingCars;
    private final TryNumber tryNumber;

    private Race(RacingCars racingCars, TryNumber tryNumber) {
        this.racingCars = racingCars;
        this.tryNumber = tryNumber;
    }

    public static Race create(RacingCars racingCars, TryNumber tryNumber) {
        return new Race(racingCars, tryNumber);
    }

    public RacingCars startRace() {
        return RacingCars.create(racingCars.moveAll());
    }

    public Map<String, Integer> findResult() {
        return racingCars.getRacingCars().stream()
                .collect(Collectors.toMap(
                        RacingCar::getName,
                        RacingCar::getPosition
                ));
    }

    public List<String> getWinners() {
        int winningPosition = findWinningPosition();
        return racingCars.getRacingCars().stream()
                .filter(car -> car.getPosition() == winningPosition)
                .map(RacingCar::getName)
                .toList();
    }

    private int findWinningPosition() {
        return racingCars.getRacingCars().stream()
                .mapToInt(RacingCar::getPosition)
                .max()
                .orElseThrow(() -> new IllegalStateException(ErrorMessage.NO_CARS_TO_RACE));
    }
}

