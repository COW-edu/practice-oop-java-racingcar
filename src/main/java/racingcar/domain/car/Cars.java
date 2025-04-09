package racingcar.domain.car;

import racingcar.domain.strategy.MovementStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> racers;
    private static final int INITIAL_POSITION = 0;

    public Cars(List<String> names) {
        this.racers = names.stream()
                .map(name -> Car.create(CarName.from(name), INITIAL_POSITION))
                .collect(Collectors.toUnmodifiableList());
    }

    public void moveAll(MovementStrategy strategy) {
        racers.forEach(car -> car.move(strategy));
    }

    public List<String> findWinnerNames() {
        int maxPosition = findMaxPosition();

        return racers.stream()
                .filter(car -> car.isAtPosition(maxPosition))
                .map(Car::displayName)
                .collect(Collectors.toList());
    }

    private int findMaxPosition() {
        return racers.stream()
                .mapToInt(Car::displayPosition)
                .max()
                .orElse(0);
    }

    public List<Car> getRacers() {
        return new ArrayList<>(racers);
    }

    @Override
    public String toString() {
        return racers.stream()
                .map(Car::toString)
                .collect(Collectors.joining("\n"));
    }
}