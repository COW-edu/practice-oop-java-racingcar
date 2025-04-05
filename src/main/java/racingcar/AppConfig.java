package racingcar;

import racingcar.controller.Controller;
import racingcar.view.InputView;
import racingcar.view.TextInputView;

public class AppConfig {

    public Controller controller() {
        return new Controller(inputView());
    }

    private InputView inputView() {
        return new TextInputView();
    }
}
