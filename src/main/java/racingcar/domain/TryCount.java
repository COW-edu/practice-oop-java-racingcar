package racingcar.domain;

import racingcar.util.ErrorMessages;

public class TryCount {
    private static final int MIN_TRY_COUNT = 1;
    private final int value;

    public TryCount(Integer value) {
        validate(value);
        this.value = value;
    }

    private void validate(int value) {
        if (value < MIN_TRY_COUNT) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_TRY_COUNT_OVER_ONE);
        }
    }

    public int getValue() {
        return value;
    }
}
