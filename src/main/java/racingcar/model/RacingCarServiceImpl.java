package racingcar.model;

import java.util.List;
import racingcar.model.domain.AllRacingCars;
import racingcar.model.domain.FullGame;
import racingcar.model.domain.RacingCar;

public class RacingCarServiceImpl implements RacingCarService {

    @Override
    public AllRacingCars createRacingCars(List<String> carNames) {
        return new AllRacingCars(convertToRacingCar(carNames));
    }

    @Override
    public FullGame createFullGame(AllRacingCars allRacingCars, int gameCount) {
        return new FullGame(allRacingCars, gameCount);
    }

    private static List<RacingCar> convertToRacingCar(List<String> carNames) {
        return carNames.stream().map(RacingCar::new).toList();
    }
}
