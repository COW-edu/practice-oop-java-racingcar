package racingcar.model.service;

import java.util.List;
import racingcar.model.domain.AllRacingCars;
import racingcar.model.domain.FullGame;

public interface RacingCarService {

    AllRacingCars createAllRacingCars(List<String> carNames);

    FullGame createFullGame(AllRacingCars allRacingCars, int gameCount);
}
