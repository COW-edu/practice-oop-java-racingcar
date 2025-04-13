package racingcar.domain.model.dto;

import racingcar.domain.model.Race;


public class FinalWinnerDTO {
    private final Race race;

    private FinalWinnerDTO(Race race) {
        this.race = race;
    }

    public static FinalWinnerDTO from(Race race) {
        return new FinalWinnerDTO(race);
    }

    public String getWinnersAsString() {
        return String.join(", ", race.getWinners());
    }


}
