package racingcar.model.service;

import java.util.List;
import racingcar.model.domain.AllRacingCars;
import racingcar.model.domain.FullGame;
import racingcar.model.domain.GameRecords;
import racingcar.model.dto.GameResultDto;

public class RacingCarServiceImpl implements RacingCarService {

    @Override
    public AllRacingCars createAllRacingCars(List<String> carNames) {
        return new AllRacingCars(carNames);
    }

    @Override
    public FullGame createFullGame(AllRacingCars allRacingCars, int gameCount) {
        return new FullGame(allRacingCars, gameCount);
    }

    @Override
    public GameResultDto getGameResult(GameRecords gameRecords) {
        return gameRecords.toDto();
    }
}
