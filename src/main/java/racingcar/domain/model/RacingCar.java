package racingcar.domain.model;

import racingcar.global.ErrorMessage;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class RacingCar {
    public static final int MIN = 0;
    public static final int MAX = 9;
    public static final int MOVE_NUMBER = 4;
    public static int START_POSITION = 0;

    private final String name;
    private int position = START_POSITION;

    private RacingCar(String name) {
        validateNameLength(name);
        validateNameEmpty(name);
        this.name = name;
    }

    public static RacingCar create(String name) {
        return new RacingCar(name);
    }

    private void validateNameLength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException(ErrorMessage.NAME_TOO_LONG);
        }
    }

    private void validateNameEmpty(String name) {
        if (name == null) {
            throw new IllegalArgumentException(ErrorMessage.NAME_MISSING);
        }
    }

    public void move() {
        if (pickNumberInRange(MIN, MAX) >= MOVE_NUMBER) {
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
