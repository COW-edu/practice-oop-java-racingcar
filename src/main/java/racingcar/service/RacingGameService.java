package racingcar.service;

import racingcar.domain.Cars;

import java.util.List;

public class RacingGameService {

    public Cars createCars(List<String> names) {
        return new Cars(names);
    }
}
