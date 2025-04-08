package racingcar.domain.model;

import racingcar.global.Constant;
import racingcar.global.ErrorMessage;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class RacingCar {
    private final String name;
    private int position = Constant.START_POSITION;

    private RacingCar(String name) {
        this.name = name;
        validateNameLength();
        validateNameEmpty();
    }

    public static RacingCar create(String name) {
        return new RacingCar(name);
    }

    private void validateNameLength() {
        if (name.length() > 5) {
            throw new IllegalArgumentException(ErrorMessage.NAME_TOO_LONG);
        }
    }

    private void validateNameEmpty() {
        if (name == null) {
            throw new IllegalArgumentException(ErrorMessage.NAME_MISSING);
        }
    }

    public void move() {
        if (pickNumberInRange(Constant.MIN, Constant.MAX) >= Constant.MOVE_NUMBER) {
            position++;
        }
    }

    public String getName() {
        return name;
    }


    public int getPosition() {
        return position;
    }
}
