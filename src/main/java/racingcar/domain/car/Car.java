package racingcar.domain.car;

import racingcar.domain.strategy.MovementStrategy;

public class Car {
    private final CarName name;
    private int position;

    public Car(CarName name, int position) {
        this.name = name;
        this.position = position;
    }

    public void advance(MovementStrategy strategy) {
        if (strategy.shouldMove()) {
            position++;
        }
    }

    public boolean isAtPosition(int position) {
        return this.position == position;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name.toString();
    }

    @Override
    public String toString() {
        return name.toString() + " : " + "-".repeat(position);
    }
}