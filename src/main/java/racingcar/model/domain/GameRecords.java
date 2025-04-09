package racingcar.model.domain;

import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import racingcar.model.dto.GameResultDto;
import racingcar.model.dto.RoundResultDto;

public final class GameRecords {

    private final Map<Integer, Round> gameRecords;

    private GameRecords(Map<Integer, Round> gameRecords) {
        this.gameRecords = gameRecords;
    }

    public static GameRecords from(Map<Integer, Round> gameRecords) {
        return new GameRecords(gameRecords);
    }

    public GameResultDto toDto() {
        Map<Integer, RoundResultDto> result = gameRecords.entrySet().stream()
                .collect(Collectors.toMap(
                        Entry::getKey,
                        entry -> entry.getValue().toDto()
                ));
        return GameResultDto.from(result);
    }
}
