package racingcar.model.domain;

import java.util.List;

public class AllRacingCars {

    private final List<RacingCar> cars;

    public AllRacingCars(List<RacingCar> cars) {
        this.cars = cars;
    }

    public List<RacingCar> getRacingCars() {
        return cars;
    }

}
