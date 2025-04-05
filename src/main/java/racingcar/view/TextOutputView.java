package racingcar.view;

import java.util.Map;
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

            for (Map.Entry<String, Integer> entry : carPositions.entrySet()) {
                String carName = entry.getKey();
                int position = entry.getValue();
                System.out.println(carName + " : " + "-".repeat(position));
            }
            System.out.println();
        }
    }

    @Override
    public void outputFinalWinners(String winners) {
        System.out.println(FINAL_WINNERS_MESSAGE + winners);
    }
}
