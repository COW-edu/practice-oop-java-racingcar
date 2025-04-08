package racingcar.view;

import racingcar.domain.model.dto.RoundResultDTO;

import java.util.Map;

public class OutputView {

    public void printInitialName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }


    public void printRoundResult(RoundResultDTO roundResultDTO) {
        roundResultDTO.getRacingCars().forEach((name, position) ->
                System.out.println(name + " : " + "-".repeat(position))
        );
        System.out.println();
    }


    public void printTryNumberNotice() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public void printWinningResult(String result) {
        System.out.println("최종 우승자 : " + result);
    }

}
