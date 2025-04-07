package racingcar.application;

import racingcar.domain.RacingGame;
import racingcar.dto.GameResult;
import racingcar.dto.RoundResult;
import racingcar.view.OutputView;

public class GameExecutor {

    private final OutputView outputView;

    public GameExecutor(OutputView outputView) {
        this.outputView = outputView;
    }

    public void executeGame(RacingGame racingGame) {
        outputView.printExecuteResult();

        for(int i = 0; i < racingGame.getTotalRound(); i++) {
            RoundResult result = racingGame.executeRound();
            outputView.printCurrentRoundResult(result);
        }
    }

    public void announceWinner(RacingGame racingGame) {
        GameResult result = racingGame.determineWinner();
        outputView.printWinner(result);
    }
}
