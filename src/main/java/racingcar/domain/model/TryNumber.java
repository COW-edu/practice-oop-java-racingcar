package racingcar.domain.model;

import racingcar.global.Constant;
import racingcar.global.ErrorMessage;

public class TryNumber {

    private final int tryNumber;

    private TryNumber(int tryNumber) {
        validateTryNumber(tryNumber);
        this.tryNumber = tryNumber;
    }

    public static TryNumber from(int tryNumber) {
        return new TryNumber(tryNumber);
    }

    private void validateTryNumber(int tryNumber) {
        if (tryNumber <= Constant.MIN) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_TRY_NUMBER);
        }
    }

    public int getTryNumber() {
        return tryNumber;
    }
}
