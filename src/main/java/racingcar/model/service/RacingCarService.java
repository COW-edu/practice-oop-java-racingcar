package racingcar.model.service;

import java.util.List;
import racingcar.model.domain.AllRacingCars;
import racingcar.model.domain.FullGame;
import racingcar.model.domain.GameRecords;
import racingcar.model.dto.GameResultDto;

public interface RacingCarService {

    AllRacingCars createAllRacingCars(List<String> carNames);

    FullGame createFullGame(AllRacingCars allRacingCars, int gameCount);

    GameResultDto getGameResult(GameRecords gameRecords);
}
