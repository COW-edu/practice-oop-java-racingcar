package racingcar.controller;

import static racingcar.common.ErrorMessage.ERROR_EMPTY_RACING_CAR_NAME;

import java.util.List;
import racingcar.view.InputView;

public class Controller {

    public static final String DELIMITER = ",";

    private final InputView inputView;

    public Controller(InputView inputView) {
        this.inputView = inputView;
    }

    public void run() {
        String inputNames = inputView.inputRacingCarNames();
        validateInputNames(inputNames);
        List<String> carNames = splitCarNames(inputNames);
    }

    private static List<String> splitCarNames(String racingCarNames) {
        List<String> carNames = List.of(racingCarNames.split(DELIMITER));
        return carNames;
    }

    private static void validateInputNames(String inputNames) {
        if (inputNames.trim().isEmpty() || inputNames == null) {
            throw new IllegalArgumentException(ERROR_EMPTY_RACING_CAR_NAME);
        }
    }

}
