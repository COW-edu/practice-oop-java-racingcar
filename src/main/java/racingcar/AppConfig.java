package racingcar;

import racingcar.controller.Controller;
import racingcar.controller.RaceController;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class AppConfig {

    public Controller controller() {
        return new RaceController(inputView(),outputView());
    }

    private InputView inputView() {
        return new InputView();
    }
    private OutputView outputView() {
        return new OutputView();
    }


}
