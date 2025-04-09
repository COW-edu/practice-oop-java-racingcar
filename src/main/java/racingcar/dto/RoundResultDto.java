package racingcar.dto;

import java.util.List;

public class RoundResultDto {
    private final List<String> carProgress;

    public RoundResultDto(List<String> carProgress) {
        this.carProgress = carProgress;
    }

    public String formatResult() {
        return String.join("\n", carProgress);
    }
}
