package racingcar.domain;

import racingcar.dto.CarStatus;

import static racingcar.common.constant.ErrorMessages.*;
import static racingcar.common.constant.GameConstants.*;

public class Car {

    private final String name;
    private int position;

    public Car(String name) {
        validateNameLength(name);
        this.name = name;
    }

    public void move() {
        position++;
    }

    private void validateNameLength(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(INVALID_CAR_NAME_LENGTH);
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public CarStatus getCarStatus() {
        return new CarStatus(name, position);
    }
}
