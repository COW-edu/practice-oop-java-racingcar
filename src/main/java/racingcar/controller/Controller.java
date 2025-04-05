package racingcar.controller;

import static racingcar.common.ErrorMessage.ERROR_EMPTY_GAME_COUNT;
import static racingcar.common.ErrorMessage.ERROR_EMPTY_RACING_CAR_NAME;
import static racingcar.common.ErrorMessage.ERROR_GAME_COUNT_FORMAT;

import java.util.List;
import racingcar.model.domain.AllRacingCars;
import racingcar.model.domain.FullGame;
import racingcar.model.domain.GameRecords;
import racingcar.model.service.RacingCarService;
import racingcar.view.InputView;

public class Controller {

    public static final String DELIMITER = ",";
    public static final String NUMERIC_REGEX = "\\d+";

    private final InputView inputView;
    private final RacingCarService racingCarService;

    public Controller(InputView inputView, RacingCarService racingCarService) {
        this.inputView = inputView;
        this.racingCarService = racingCarService;
    }

    public void run() {
        String inputNames = inputView.inputRacingCarNames();
        validateInputNames(inputNames);
        List<String> carNames = splitCarNames(inputNames);
        AllRacingCars allRacingCars = racingCarService.createAllRacingCars(carNames);

        String inputCount = inputView.inputGameCount();
        validateInputCount(inputCount);
        int gameCount = Integer.parseInt(inputCount);
        FullGame fullGame = racingCarService.createFullGame(allRacingCars, gameCount);
        GameRecords gameRecords = fullGame.startGame();
    }

    private void validateInputCount(String inputCount) {
        if (inputCount.trim().isEmpty() || inputCount == null) {
            throw new IllegalArgumentException(ERROR_EMPTY_GAME_COUNT);
        }
        if (!inputCount.matches(NUMERIC_REGEX)) {
            throw new IllegalArgumentException(ERROR_GAME_COUNT_FORMAT);
        }
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
