package racingcar.model.domain;

import java.util.HashMap;
import java.util.Map;
import racingcar.model.dto.GameResultDto;
import racingcar.model.dto.RoundResultDto;

public final class GameRecords {

    private final Map<Integer, Game> gameRecords = new HashMap<>();

    public void record(int round, Game game) {
        gameRecords.put(round, game);
    }

    public GameResultDto toDto() {
        Map<Integer, RoundResultDto> result = new HashMap<>();
        for (Map.Entry<Integer, Game> entry : gameRecords.entrySet()) {
            result.put(entry.getKey(), entry.getValue().toDto());
        }
        return new GameResultDto(result);
    }
}
