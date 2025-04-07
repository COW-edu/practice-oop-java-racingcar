package racingcar.domain;

import racingcar.dto.CarStatus;

public class Car {

    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
    }

    public void move() {
        position++;
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
