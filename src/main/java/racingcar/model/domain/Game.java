package racingcar.model.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashMap;
import java.util.Map;

public class Game {

    private final Map<RacingCar, Integer> game = new HashMap<>();

    public void play(RacingCar car) {
        if (Randoms.pickNumberInRange(0,9) > 4) {
            game.put(car, game.getOrDefault(car, 0) + 1);
        }
    }
}
