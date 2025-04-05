package racingcar.model.domain;

import java.util.List;
import racingcar.model.dto.FinalWinnersDto;

public class FinalWinners {

    private final List<RacingCar> finalWinners;

    public FinalWinners(List<RacingCar> winners) {
        this.finalWinners = winners;
    }

    public FinalWinnersDto toDto() {
        return new FinalWinnersDto(finalWinners.stream().map(RacingCar::getName).toList());
    }
}
