package racingcar;

import racingcar.controller.Controller;
import racingcar.view.InputView;
import racingcar.view.OutputView;
import racingcar.view.TextInputView;
import racingcar.view.TextOutputView;

public final class AppConfig {

    public Controller controller() {
        return new Controller(inputView(), outputView());
    }

    private InputView inputView() {
        return new TextInputView();
    }

    private OutputView outputView() {
        return new TextOutputView();
    }
}
