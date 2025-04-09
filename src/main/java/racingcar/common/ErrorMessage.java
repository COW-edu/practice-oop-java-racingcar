package racingcar.common;

public class ErrorMessage {
    private static final String ERROR_MESSAGE = "[ERROR]";

    public static final String ERROR_EMPTY_RACING_CAR_NAME = ERROR_MESSAGE + "입력된 자동차 이름이 없습니다.";
    public static final String ERROR_SINGLE_RACING_CAR_NAME = ERROR_MESSAGE + "한 대의 자동차로는 경기할 수 없습니다.";
    public static final String ERROR_EMPTY_GAME_COUNT = ERROR_MESSAGE + "입력된 경기 횟수가 없습니다.";
    public static final String ERROR_GAME_COUNT_FORMAT = ERROR_MESSAGE + "경기 횟수는 정수여야 합니다.";
    public static final String ERROR_TOO_SMALL_GAME_COUNT = ERROR_MESSAGE + "시도 횟수는 0보다 커야 합니다.";
}
