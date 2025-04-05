package racingcar.domain.model;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class RacingMachine {

    public boolean isMoveable() {
        return pickNumberInRange(0,9) >= 4;
    }

}
