package racingcar.model;

import java.util.List;

public class RacingCarServiceImpl implements RacingCarService {

    @Override
    public void createRacingCars(List<String> carNames) {
        AllRacingCars allRacingCars = new AllRacingCars(convertToRacingCar(carNames));
    }

    private static List<RacingCar> convertToRacingCar(List<String> carNames) {
        return carNames.stream().map(RacingCar::new).toList();
    }
}
