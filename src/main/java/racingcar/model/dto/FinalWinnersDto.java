package racingcar.model.dto;

import java.util.List;

public class FinalWinnersDto {

    private final List<String> winners;

    private FinalWinnersDto(List<String> winners) {
        this.winners = winners;
    }

    public List<String> getWinners() {
        return winners;
    }

    public static FinalWinnersDto from(List<String> winners) {
        return new FinalWinnersDto(winners);
    }
}
