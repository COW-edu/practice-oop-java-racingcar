package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.domain.TryCount;
import racingcar.domain.strategy.MoveStrategy;
import racingcar.service.RacingGameService;
import racingcar.view.InputView;
import racingcar.view.OutputView;
import racingcar.util.InputParser;

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
        TryCount tryCount = new TryCount(InputParser.parseTryCount(inputView.readTryCount()));
        repeatMoveAndPrint(cars, tryCount.getValue(), strategy);
        outputView.printWinners(cars.findWinners());

    }

    private void repeatMoveAndPrint(Cars cars, int tryCount, MoveStrategy strategy) {
        for (int i = 0; i < tryCount; i++) {
            cars.moveAll(strategy);
            outputView.printCars(cars.getCars());
        }
    }

    private Cars createRacingCars() {
        List<String> carNames = InputParser.parseCarNames(inputView.createCarNames());
        return racingGameService.createCars(carNames);
    }
}
