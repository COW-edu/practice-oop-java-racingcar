package racingcar.domain.model;

import racingcar.global.ErrorMessage;

import java.util.List;
import java.util.stream.Collectors;

public class RacingCars {
    private final List<RacingCar> racingCars;

    private RacingCars(List<RacingCar> racingCars) {
        this.racingCars = racingCars;
        validateNameListEmpty();
        validateDuplicateName();

    }

    public static RacingCars create(List<RacingCar> userInput) {
        return new RacingCars(userInput);
    }

    public List<RacingCar> moveAll() {
        racingCars.forEach(RacingCar::move);
        return racingCars;
    }


    private void validateDuplicateName() {
        if (racingCars.size() != racingCars.stream().distinct().count()) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NAME);
        }
    }

    private void validateNameListEmpty() {
        if (racingCars.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_NAME_LIST);
        }
    }


    public List<RacingCar> getRacingCars() {
        return racingCars.stream().collect(Collectors.toUnmodifiableList());
    }
}
