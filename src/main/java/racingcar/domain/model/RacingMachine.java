package racingcar.domain.model;

import racingcar.domain.rule.MoveStrategy;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class RacingMachine implements MoveStrategy {

    @Override
    public boolean isMoveable() {
        return pickNumberInRange(0,9) >= 4;
    }
}
