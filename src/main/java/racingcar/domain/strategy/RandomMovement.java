package racingcar.domain.strategy;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomMovement implements MovementStrategy {
    private static final int MIN_VALUE = 0;
    private static final int MAX_VALUE = 9;
    private static final int THRESHOLD = 4;

    @Override
    public boolean shouldMove() {
        return Randoms.pickNumberInRange(MIN_VALUE, MAX_VALUE) >= THRESHOLD;
    }
}