package racingcar.model.domain;

import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import racingcar.model.dto.RoundResultDto;

final class Round {

    private final Map<RacingCar, Integer> round;

    private Round(Map<RacingCar, Integer> round) {
        this.round = round;
    }

    public static Round from(Map<RacingCar, Integer> round) {
        return new Round(round);
    }

    public RoundResultDto toDto() {
        Map<String, Integer> result = round.entrySet().stream()
                .collect(Collectors.toMap(
                        entry -> entry.getKey().getName(),
                        Entry::getValue
                ));
        return RoundResultDto.from(result);
    }
}
