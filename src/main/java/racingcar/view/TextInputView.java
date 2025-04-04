package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class TextInputView implements InputView {

    @Override
    public String inputRacingCarsNames() {
        return Console.readLine();
    }

    @Override
    public String inputGameCount() {
        return Console.readLine();
    }
}
