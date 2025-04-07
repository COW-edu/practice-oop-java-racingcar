package racingcar.view;

import racingcar.dto.CarStatus;
import racingcar.dto.GameResult;
import racingcar.dto.RoundResult;

import java.util.List;

public class OutputView {

    public void printExecuteResult() {
        System.out.println("실행 결과");
    }

    public void printCurrentRoundResult(RoundResult result) {
        List<CarStatus> carStatuses = result.getCarStatuses();

        for (CarStatus carStatus : carStatuses) {
            String name = carStatus.name();
            int position = carStatus.position();
            System.out.println(name + " : " + getPosition(position));
        }
        System.out.println();
    }


    public void printWinner(GameResult result) {
        System.out.println("최종 우승자");
        List<String> carStatuses = result.getWinnerNames();
        System.out.println(String.join(", ", carStatuses));
    }

    private String getPosition(int position) {
        return "-".repeat(Math.max(0, position));
    }
}
