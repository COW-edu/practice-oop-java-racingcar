package racingcar.model.dto;

import java.util.Map;

public class GameResultDto {

    private final Map<Integer, RoundResultDto> gameResult;

    public GameResultDto(Map<Integer, RoundResultDto> gameResult) {
        this.gameResult = gameResult;
    }

    public Map<Integer, RoundResultDto> getGameResult() {
        return gameResult;
    }
}
