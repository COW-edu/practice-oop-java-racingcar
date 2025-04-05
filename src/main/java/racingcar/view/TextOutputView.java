package racingcar.view;

import racingcar.model.dto.GameResultDto;

public class TextOutputView implements OutputView {

    public static final String GAME_RECORDS_MESSAGE = "실행 결과";
    public static final String FINAL_WINNERS_MESSAGE = "최종 우승자 : ";

    @Override
    public void outputGameRecords(GameResultDto gameResultDto) {
        System.out.println(GAME_RECORDS_MESSAGE);
    }

    @Override
    public void outputFinalWinners(String winners) {
        System.out.println(FINAL_WINNERS_MESSAGE + winners);
    }
}
