package racingcar.domain.strategy;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomMoveStrategy implements MoveStrategy {

    private static final int RANDOM_MIN = 0;
    private static final int RANDOM_MAX = 9;
    private static final int MIN_MOVE_NUMBER = 4;

    @Override
    public boolean movable() {
        int number = Randoms.pickNumberInRange(RANDOM_MIN, RANDOM_MAX);
        return number >= MIN_MOVE_NUMBER;
    }
}
