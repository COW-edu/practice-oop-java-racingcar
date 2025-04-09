package racingcar.domain.car;

import static racingcar.constants.ErrorMessage.NAME_ERROR;

public class CarName {
    private final String value;
    private static final int NAME_LIMIT_LENGTH = 5;
    public CarName(String value) {
        validateName(value);
        this.value = value;
    }

    private void validateName(String name) {
        if (name.length() > NAME_LIMIT_LENGTH) {
            throw new IllegalArgumentException(NAME_ERROR.toString());
        }
    }

    @Override
    public String toString() {
        return value;
    }
}
