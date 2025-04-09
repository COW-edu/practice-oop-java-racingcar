package racingcar.domain.car;

import racingcar.domain.strategy.MovementStrategy;

public class Car {
    private final CarName name;
    private int position;

    public Car(CarName name, int position) {
        this.name = name;
        this.position = position;
    }

    public static Car create(CarName name, int position) {
        return new Car(name, position);
    }

    public Car move(MovementStrategy strategy) {
        if (strategy.shouldMove()) {
            return new Car(this.name, this.position + 1);
        }
        return this;
    }

    public boolean isAtPosition(int position) {
        return this.position == position;
    }

    public int displayPosition() {
        return position;
    }

    public String displayName() {
        return name.toString();
    }

    @Override
    public String toString() {
        return name.toString() + " : " + "-".repeat(position);
    }
}