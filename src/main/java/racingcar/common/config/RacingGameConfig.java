package racingcar.common.config;

import racingcar.common.constant.ErrorMessages;

import java.util.ArrayList;
import java.util.List;

public class RacingGameConfig {

    private final List<String> carNames = new ArrayList<>();
    private final int totalRound;

    public RacingGameConfig(List<String> carNames, int totalRound) {
        validateCarNames(carNames);
        validateTotalRound(totalRound);
        this.carNames.addAll(carNames);
        this.totalRound = totalRound;
    }

    public List<String> getCarNames() {
        return carNames;
    }

    public int getTotalRound() {
        return totalRound;
    }

    private void validateCarNames(List<String> carNames) {
        if(carNames == null || carNames.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessages.EMPTY_CAR_NAMES);
        }
    }

    private void validateTotalRound(int totalRound) {
        if(totalRound <= 0) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_TOTAL_ROUND);
        }
    }
}
