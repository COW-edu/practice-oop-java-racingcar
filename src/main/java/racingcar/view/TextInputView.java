package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class TextInputView implements InputView {

    public static final String INPUT_RACING_CARS_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String INPUT_GAME_COUNT_MESSAGE = "시도할 회수는 몇회인가요?";

    @Override
    public String inputRacingCarNames() {
        System.out.println(INPUT_RACING_CARS_NAME_MESSAGE);
        return Console.readLine();
    }

    @Override
    public String inputGameCount() {
        System.out.println(INPUT_GAME_COUNT_MESSAGE);
        return Console.readLine();
    }
}
