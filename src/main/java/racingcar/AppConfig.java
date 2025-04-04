package racingcar;

import racingcar.controller.Controller;
import racingcar.model.RacingCarService;
import racingcar.model.RacingCarServiceImpl;
import racingcar.view.InputView;
import racingcar.view.TextInputView;

public class AppConfig {

    public Controller controller() {
        return new Controller(inputView(), racingCarService());
    }

    private InputView inputView() {
        return new TextInputView();
    }

    private RacingCarService racingCarService() {
        return new RacingCarServiceImpl();
    }
}
