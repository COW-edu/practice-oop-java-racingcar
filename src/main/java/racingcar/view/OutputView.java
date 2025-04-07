package racingcar.view;

import racingcar.common.constant.UIConstants;
import racingcar.dto.CarStatus;
import racingcar.dto.GameResult;
import racingcar.dto.RoundResult;

import java.util.List;

public class OutputView {

    public void printExecuteResult() {
        System.out.println(UIConstants.EXECUTE_RESULT);
    }

    public void printCurrentRoundResult(RoundResult result) {
        List<CarStatus> carStatuses = result.getCarStatuses();

        for (CarStatus carStatus : carStatuses) {
            String name = carStatus.name();
            int position = carStatus.position();
            System.out.println(name + UIConstants.DELIMITER_COLON + getPosition(position));
        }
        System.out.println();
    }


    public void printWinner(GameResult result) {
        System.out.println(UIConstants.WINNER_ANNOUNCEMENT);
        List<String> carStatuses = result.getWinnerNames();
        System.out.println(String.join(UIConstants.WINNER_DELIMITER, carStatuses));
    }

    private String getPosition(int position) {
        return UIConstants.POSITION_INDICATOR.repeat(Math.max(0, position));
    }
}
