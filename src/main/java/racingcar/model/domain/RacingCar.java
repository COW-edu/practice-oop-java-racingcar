package racingcar.model.domain;

import camp.nextstep.edu.missionutils.Randoms;

public final class RacingCar {

    public static final int MIN_NUMBER = 0;
    public static final int MAX_NUMBER = 9;
    public static final int JUDGE_NUMBER = 4;

    private final String name;
    private int position = 0;

    public RacingCar(String name) {
        this.name = name;
    }

    public void move() {
        if (Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER) > JUDGE_NUMBER) {
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
