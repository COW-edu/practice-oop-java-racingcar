package racingcar.view;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import racingcar.model.dto.FinalWinnersDto;
import racingcar.model.dto.GameResultDto;
import racingcar.model.dto.RoundResultDto;

public final class TextOutputView implements OutputView {

    public static final String GAME_RECORDS_MESSAGE = "실행 결과";
    public static final String FINAL_WINNERS_MESSAGE = "최종 우승자 : ";
    public static final String EXPRESS_POSITION = "-";
    public static final int START_ROUND = 1;
    public static final int MIN_WINNERS_COUNT = 1;

    @Override
    public void outputGameRecords(GameResultDto gameResultDto) {
        System.out.println(GAME_RECORDS_MESSAGE);

        Map<Integer, RoundResultDto> gameResult = gameResultDto.getGameResult();

        for (int round = START_ROUND; round <= gameResult.size(); round++) {
            RoundResultDto roundResult = gameResult.get(round);
            Map<String, Integer> carPositions = roundResult.getRoundResult();

            for (Entry<String, Integer> entry : carPositions.entrySet()) {
                String carName = entry.getKey();
                int position = entry.getValue();
                System.out.println(carName + " : " + EXPRESS_POSITION.repeat(position));
            }
            System.out.println();
        }
    }

    @Override
    public void outputFinalWinners(FinalWinnersDto finalWinnersDto) {
        System.out.print(FINAL_WINNERS_MESSAGE);

        List<String> winners = finalWinnersDto.getWinners();
        int winnersCount = winners.size();
        
        for (int i = MIN_WINNERS_COUNT; i <= winnersCount; i++) {
            System.out.print(winners.get(i-1));
            if (i < winnersCount) {
                System.out.print(", ");
            }
        }
    }
}
