package racingcar.application;

import racingcar.common.parser.InputParser;
import racingcar.common.config.RacingGameConfig;
import racingcar.view.InputView;

import java.util.List;

public class GameSetUp {

    private final InputView inputView;
    private final InputParser inputParser;

    public GameSetUp(InputView inputView, InputParser inputParser) {
        this.inputView = inputView;
        this.inputParser = inputParser;
    }

    public RacingGameConfig createRacingGameConfig() {
        List<String> carNames = setUpCarNames();
        int totalRound = setUpTotalRound();
        return new RacingGameConfig(carNames, totalRound);
    }

    private List<String> setUpCarNames() {
        String carNamesInput = inputView.printCarNames();
        return inputParser.parseCarNames(carNamesInput);
    }

    private int setUpTotalRound() {
        String totalRoundInput = inputView.printRaceCount();
        return inputParser.parseTotalRound(totalRoundInput);
    }
}
