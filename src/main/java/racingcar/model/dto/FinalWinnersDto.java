package racingcar.model.dto;

import java.util.List;

public class FinalWinnersDto {

    private final List<String> winners;

    public FinalWinnersDto(List<String> winners) {
        this.winners = winners;
    }

    public List<String> getWinners() {
        return winners;
    }
}
