package racingcar.model;

import java.util.List;
import racingcar.model.domain.AllRacingCars;
import racingcar.model.domain.FullGame;

public interface RacingCarService {

    AllRacingCars createRacingCars(List<String> carNames);

    FullGame createFullGame(AllRacingCars allRacingCars, int GameCount);
}
