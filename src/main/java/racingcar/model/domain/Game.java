package racingcar.model.domain;

import java.util.HashMap;
import java.util.Map;

public class Game {

    private final Map<RacingCar, Integer> game = new HashMap<>();

    public void move(RacingCar car) {
        game.put(car, game.getOrDefault(car, 0) + 1);
    }
}
