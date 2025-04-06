package racingcar.model.dto;

import java.util.Map;

public class GameResultDto {

    private final Map<Integer, RoundResultDto> gameResult;

    private GameResultDto(Map<Integer, RoundResultDto> gameResult) {
        this.gameResult = gameResult;
    }

    public Map<Integer, RoundResultDto> getGameResult() {
        return gameResult;
    }

    public static GameResultDto from(Map<Integer, RoundResultDto> gameResult) {
        return new GameResultDto(gameResult);
    }
}
