package racingcar.controller;

import static racingcar.common.ErrorMessage.ERROR_EMPTY_GAME_COUNT;
import static racingcar.common.ErrorMessage.ERROR_EMPTY_RACING_CAR_NAME;
import static racingcar.common.ErrorMessage.ERROR_GAME_COUNT_FORMAT;

import java.util.List;
import racingcar.model.domain.AllRacingCars;
import racingcar.model.domain.FullGame;
import racingcar.model.domain.GameRecords;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Controller {

    public static final String DELIMITER = ",";
    public static final String NUMERIC_REGEX = "\\d+";

    private final InputView inputView;
    private final OutputView outputView;

    public Controller(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        AllRacingCars allRacingCars = createAllRacingCars();

        FullGame fullGame = createFullGame(allRacingCars);

        getGameRecords(fullGame);

        getFinalWinners(allRacingCars);
    }

    private void getFinalWinners(AllRacingCars allRacingCars) {
        outputView.outputFinalWinners(allRacingCars.getFinalWinners().toDto());
    }

    private void getGameRecords(FullGame fullGame) {
        GameRecords gameRecords = fullGame.playAllRounds();
        outputView.outputGameRecords(gameRecords.toDto());
    }

    private FullGame createFullGame(AllRacingCars allRacingCars) {
        String inputCount = inputView.inputGameCount();
        validateInputCount(inputCount);
        int gameCount = Integer.parseInt(inputCount);
        return FullGame.of(allRacingCars, gameCount);
    }

    private AllRacingCars createAllRacingCars() {
        String inputNames = inputView.inputRacingCarNames();
        validateInputNames(inputNames);
        List<String> carNames = splitCarNames(inputNames);
        return AllRacingCars.from(carNames);
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
        return List.of(racingCarNames.split(DELIMITER));
    }

    private static void validateInputNames(String inputNames) {
        if (inputNames.trim().isEmpty() || inputNames == null) {
            throw new IllegalArgumentException(ERROR_EMPTY_RACING_CAR_NAME);
        }
    }

}
