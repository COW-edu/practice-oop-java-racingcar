package racingcar.model.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import racingcar.model.dto.GameResultDto;
import racingcar.model.dto.RoundResultDto;

public final class GameRecords {

    private final Map<Integer, Game> gameRecords = new HashMap<>();

    public void record(int round, Game game) {
        gameRecords.put(round, game);
    }

    public GameResultDto toDto() {
        Map<Integer, RoundResultDto> result = gameRecords.entrySet().stream()
                .collect(Collectors.toMap(
                        Entry::getKey,
                        entry -> entry.getValue().toDto()
                ));
        return new GameResultDto(result);
    }
}
