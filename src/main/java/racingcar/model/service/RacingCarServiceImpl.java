package racingcar.model.service;

import java.util.List;
import racingcar.model.domain.AllRacingCars;
import racingcar.model.domain.FullGame;
import racingcar.model.domain.GameRecords;
import racingcar.model.dto.FinalWinnersDto;
import racingcar.model.dto.GameResultDto;

public final class RacingCarServiceImpl implements RacingCarService {

    @Override
    public AllRacingCars createAllRacingCars(List<String> carNames) {
        return AllRacingCars.from(carNames);
    }

    @Override
    public FullGame createFullGame(AllRacingCars allRacingCars, int gameCount) {
        return FullGame.of(allRacingCars, gameCount);
    }

    @Override
    public GameResultDto getGameResult(GameRecords gameRecords) {
        return gameRecords.toDto();
    }

    @Override
    public FinalWinnersDto getFinalWinners(AllRacingCars allRacingCars) {
        return allRacingCars.getFinalWinners().toDto();
    }

}
