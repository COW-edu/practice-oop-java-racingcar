package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.domain.strategy.MoveStrategy;
import racingcar.service.RacingGameService;
import racingcar.util.ErrorMessages;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.Arrays;
import java.util.List;

public class RacingGameController {
    private final InputView inputView;
    private final OutputView outputView;
    private final RacingGameService racingGameService;

    public RacingGameController(InputView inputView, OutputView outputView, RacingGameService racingGameService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.racingGameService = racingGameService;
    }
    public void run(MoveStrategy strategy) {
        Cars cars = createRacingCars();
        int tryCount = parsingTryCounts(inputView.readTryCount());
        repeatMoveAndPrint(cars, tryCount, strategy);
        outputView.printWinners(cars.findWinners());

    }


    private void repeatMoveAndPrint(Cars cars, int tryCount, MoveStrategy strategy) {
        for (int i = 0; i < tryCount; i++) {
            cars.moveAll(strategy);
            outputView.printCars(cars.getCars());
        }
    }

    private Cars createRacingCars() {
        List<String> carNames = parsingCarNames(inputView.createCarNames());
        return racingGameService.createCars(carNames);

    }

    private int parsingTryCounts(String tryCount) {
        try {
            return Integer.parseInt(tryCount);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException(ErrorMessages.INVALID_TRY_COUNT);
        }
    }

    private List<String> parsingCarNames(String carNames) {
      return Arrays.stream(carNames.split(","))
                .map(String::trim)
                .filter(name -> !name.isBlank())
                .toList();
    }
}
