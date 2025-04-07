package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.common.constant.UIConstants;

public class InputView {

    public String printCarNames() {
        System.out.println(UIConstants.CAR_NAMES_PROMPT);
        return Console.readLine();
    }

    public String printRaceCount() {
        System.out.println(UIConstants.RACE_COUNT_PROMPT);
        return Console.readLine();
    }
}
