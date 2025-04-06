package racingcar.model.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import racingcar.model.dto.RoundResultDto;

public final class Game {

    private final Map<RacingCar, Integer> game = new HashMap<>();

    public void play(RacingCar car) {
        car.move();
        game.put(car, car.getPosition());
    }

    public RoundResultDto toDto() {
        Map<String, Integer> result = game.entrySet().stream()
                .collect(Collectors.toMap(
                        entry -> entry.getKey().getName(),
                        Entry::getValue
                ));
        return new RoundResultDto(result);
    }
}
