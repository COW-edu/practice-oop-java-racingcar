package racingcar.domain;


import racingcar.common.constant.ErrorMessages;
import racingcar.dto.GameResult;
import racingcar.common.config.RacingGameConfig;
import racingcar.dto.RoundResult;

public class RacingGame {

    private final RaceTrack raceTrack;
    private final int totalRound;
    private int currentRound;

    public RacingGame(RacingGameConfig config) {
        this.raceTrack = new RaceTrack(config.getCarNames());
        this.totalRound = config.getTotalRound();
        this.currentRound = 0;
    }

    public RoundResult executeRound() {
        validateCurrentRound();
        raceTrack.moveAllCars();
        currentRound++;
        return new RoundResult(raceTrack.getCarStatuses());
    }

    public GameResult determineWinner() {
        return raceTrack.determineWinner();
    }

    private void validateCurrentRound() {
        if(currentRound >= totalRound) {
            throw new IllegalStateException(ErrorMessages.ALL_ROUNDS_COMPLETED);
        }
    }

    public int getTotalRound() {
        return totalRound;
    }
}
