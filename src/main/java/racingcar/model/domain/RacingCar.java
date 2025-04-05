package racingcar.model.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingCar {

    private final String name;
    private int position = 0;

    public RacingCar(String name) {
        this.name = name;
    }

    public void move() {
        if (Randoms.pickNumberInRange(0, 9) > 4) {
            position++;
        }
    }

    public boolean isSamePosition(int otherPosition) {
        return this.position == otherPosition;
    }

    public String getName() {
        return this.name;
    }

    public Integer getPosition() {
        return position;
    }
}
