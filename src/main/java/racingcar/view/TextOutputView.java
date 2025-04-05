package racingcar.view;

import java.util.List;

public class TextOutputView implements OutputView {

    public static final String GAME_RECORDS_MESSAGE = "실행 결과";
    public static final String FINAL_WINNERS_MESSAGE = "최종 우승자 : ";

    @Override
    public void outputGameRecords(List<String> gameRecords) {
        System.out.println(GAME_RECORDS_MESSAGE);
        for (String gameRecord : gameRecords) {
            System.out.println(gameRecord);
        }
    }

    @Override
    public void outputFinalWinners(String winners) {
        System.out.println(FINAL_WINNERS_MESSAGE + winners);
    }
}
