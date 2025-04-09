package racingcar.constants;

public enum ErrorMessage {
    NAME_ERROR("자동차 이름을 입력해야 합니다."),
    NAME_TPYE_ERROR("자동차 이름은 5자 이하만 가능합니다."),

    CHANCE_NEGATIVE_ERROR("시도 횟수는 양수여야 합니다."),
    CHANCE_TYPE_ERROR("시도 횟수는 숫자여야 합니다.");

    private String message;
    ErrorMessage(String message) {
        this.message = message;
    }
    @Override
    public String toString() {
        return message;
    }
}
