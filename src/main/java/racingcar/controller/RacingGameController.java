package racingcar.controller;


import racingcar.application.GameExecutor;
import racingcar.application.GameSetUp;
import racingcar.application.RacingGameFacade;
import racingcar.common.parser.InputParser;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameController {

    private final RacingGameFacade racingGameFacade;

    public RacingGameController(
            InputView inputView,
            OutputView outputView,
            InputParser inputParser
    ) {
        GameSetUp gameSetUp = new GameSetUp(inputView, inputParser);
        GameExecutor gameExecutor = new GameExecutor(outputView);
        racingGameFacade = new RacingGameFacade(gameSetUp, gameExecutor);
    }

    public void run() {
        racingGameFacade.playGame();
    }
}
