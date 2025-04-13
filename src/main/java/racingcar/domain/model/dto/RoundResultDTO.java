package racingcar.domain.model.dto;

import racingcar.domain.model.Race;
import racingcar.domain.model.RacingCars;

import java.util.Map;

public class RoundResultDTO {
    private final RacingCars racingCars;
    private final Race race;

    private RoundResultDTO(RacingCars racingCars, Race race) {
        this.racingCars = racingCars;
        this.race = race;
    }


    public static RoundResultDTO from(RacingCars racingCars, Race race) {
        return new RoundResultDTO(racingCars, race);
    }


    public Map<String,Integer> getRacingCars() {
       return race.findResult();
    }
}
