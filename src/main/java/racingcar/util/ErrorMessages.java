package racingcar.util;

public class ErrorMessages {
    private static final String ERROR_PREFIX = "[ERROR] ";

    public static final String INVALID_CAR_NAME_BLANK = ERROR_PREFIX + "자동차 이름은 비어 있을 수 없습니다.";
    public static final String TOO_LONG_CAR_NAME = ERROR_PREFIX + "자동차 이름은 5자 이하여야 합니다.";
    public static final String DUPLICATE_CAR_NAME = ERROR_PREFIX + "중복된 자동차 이름이 존재합니다.";

}
