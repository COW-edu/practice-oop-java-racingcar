package racingcar.domain;

import racingcar.domain.strategy.MoveStrategy;
import racingcar.util.ErrorMessages;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Cars {
    private static final int DEFAULT_POSITION = 0;

    private final List<Car> cars;

    public Cars(List<String> carNames) {
        List<Car> carList = carNames.stream()
                .map(Car::new)
                .toList();
        validateDuplicateCars(carList);
        this.cars = carList;
    }

    private void validateDuplicateCars(List<Car> carList) {
        Set<Car> uniqueCars = new HashSet<>(carList);
        if (uniqueCars.size() != carList.size()) {
            throw new IllegalArgumentException(ErrorMessages.DUPLICATE_CAR_NAME);
        }
    }

    public void moveAll(MoveStrategy strategy) {
        cars.forEach(car -> car.move(strategy));
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public List<Car> findWinners() {
        int maxPosition = findMaxPosition();
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .toList();
    }

    private int findMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(DEFAULT_POSITION);
    }
}
