package racingcar.domain.model;

import java.util.List;

public class RacingCars {
    private List<RacingCar> racingCars;

    private RacingCars(List<RacingCar> carNames) {
        this.racingCars = carNames;
        validateNameListEmpty();
        validateDuplicateName();

    }

    public static RacingCars create(List<RacingCar> userInput) {
        return new RacingCars(userInput);
    }

    private void validateDuplicateName() {
        if (racingCars.size() != racingCars.stream().distinct().count()) {
            throw new IllegalArgumentException("중복된 이름이 존재합니다.");
        }
    }

    private void validateNameListEmpty() {
        if (racingCars.isEmpty()) {
            throw new IllegalArgumentException("이름 목록이 비어있습니다.");
        }
    }

}
