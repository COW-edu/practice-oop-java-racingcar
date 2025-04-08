package racingcar.domain.model.dto;

import racingcar.domain.model.Race;
import racingcar.domain.model.RacingCar;
import racingcar.domain.model.RacingCars;

import java.util.stream.Collectors;

public class FinalWinnerDTO {
    private final Race race;

    public FinalWinnerDTO(Race race) {
        this.race = race;
    }

    public static FinalWinnerDTO from(Race race) {
        return new FinalWinnerDTO(race);
    }

    public String getWinnersAsString() {
        return String.join(", ", race.getWinners());
    }


}
