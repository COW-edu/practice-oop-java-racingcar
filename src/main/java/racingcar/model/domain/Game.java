package racingcar.model.domain;

import java.util.HashMap;
import java.util.Map;
import racingcar.model.dto.RoundResultDto;

public class Game {

    private final Map<RacingCar, Integer> game = new HashMap<>();

    public void play(RacingCar car) {
        car.move();
        game.put(car, car.getPosition());
    }

    public RoundResultDto toDto() {
        Map<String, Integer> result = new HashMap<>();
        for (Map.Entry<RacingCar, Integer> entry : game.entrySet()) {
            result.put(entry.getKey().getName(), entry.getValue());
        }
        return new RoundResultDto(result);
    }
}
