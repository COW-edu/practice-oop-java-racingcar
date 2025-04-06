package racingcar.model.dto;

import java.util.Map;

public final class RoundResultDto {

    private final Map<String, Integer> roundResult;

    private RoundResultDto(Map<String, Integer> roundResult) {
        this.roundResult = roundResult;
    }

    public Map<String, Integer> getRoundResult() {
        return roundResult;
    }

    public static RoundResultDto from(Map<String, Integer> roundResult) {
        return new RoundResultDto(roundResult);
    }
}
