package racingcar.domain;

import racingcar.domain.strategy.MoveStrategy;
import racingcar.util.ErrorMessages;

import java.util.Objects;

public class Car {
    private static final int START_POSITION = 0;
    private static final int MAX_CAR_NAME_LENGTH = 5;

    private final String carName;
    private int position = START_POSITION;

    public Car(String carName) {
        validateCarName(carName);
        this.carName = carName;
    }

    private void validateCarName(String carName) {
        if (carName == null || carName.isBlank()) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_CAR_NAME_BLANK);
        }
        if (carName.length() > MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException(ErrorMessages.TOO_LONG_CAR_NAME);
        }
    }
    public void move(MoveStrategy strategy) {
        if (strategy.movable()) {
            position++;
        }
    }

    public String getName() {
        return carName;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;
        Car car = (Car) o;
        return Objects.equals(carName, car.carName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carName);
    }
}
