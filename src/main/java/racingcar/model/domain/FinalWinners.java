package racingcar.model.domain;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.dto.FinalWinnersDto;

public final class FinalWinners {

    private final List<RacingCar> finalWinners;

    private FinalWinners(final List<RacingCar> finalWinners) {
        this.finalWinners = finalWinners;
    }

    public static FinalWinners of(List<RacingCar> cars, int maxPosition) {
        List<RacingCar> result = calculateFinalWinners(cars, maxPosition);
        return new FinalWinners(result);
    }

    private static List<RacingCar> calculateFinalWinners(List<RacingCar> cars, int maxPosition) {
        return cars.stream()
                .filter(car -> car.isSamePosition(maxPosition))
                .collect(Collectors.toList());
    }

    public FinalWinnersDto toDto() {
        return FinalWinnersDto.from(finalWinners.stream().map(RacingCar::getName).toList());
    }

}
