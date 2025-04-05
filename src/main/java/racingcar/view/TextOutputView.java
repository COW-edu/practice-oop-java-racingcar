package racingcar.view;

import java.util.Map;
import java.util.Map.Entry;
import racingcar.model.dto.FinalWinnersDto;
import racingcar.model.dto.GameResultDto;
import racingcar.model.dto.RoundResultDto;

public class TextOutputView implements OutputView {

    public static final String GAME_RECORDS_MESSAGE = "실행 결과";
    public static final String FINAL_WINNERS_MESSAGE = "최종 우승자 : ";

    @Override
    public void outputGameRecords(GameResultDto gameResultDto) {
        System.out.println(GAME_RECORDS_MESSAGE);

        Map<Integer, RoundResultDto> gameResult = gameResultDto.getGameResult();

        for (int round = 1; round <= gameResult.size(); round++) {
            RoundResultDto roundResult = gameResult.get(round);
            Map<String, Integer> carPositions = roundResult.getRoundResult();

            for (Entry<String, Integer> entry : carPositions.entrySet()) {
                String carName = entry.getKey();
                int position = entry.getValue();
                System.out.println(carName + " : " + "-".repeat(position));
            }
            System.out.println();
        }
    }

    @Override
    public void outputFinalWinners(FinalWinnersDto finalWinnersDto) {
        System.out.print(FINAL_WINNERS_MESSAGE);
        for (int i = 1; i<=finalWinnersDto.getWinners().size(); i++) {
            System.out.print(finalWinnersDto.getWinners().get(i-1));
            if (i < finalWinnersDto.getWinners().size()) {
                System.out.print(", ");
            }
        }
    }
}
