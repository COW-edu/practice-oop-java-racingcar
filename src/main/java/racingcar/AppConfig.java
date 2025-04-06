package racingcar;

import racingcar.controller.Controller;
import racingcar.model.service.RacingCarService;
import racingcar.model.service.RacingCarServiceImpl;
import racingcar.view.InputView;
import racingcar.view.OutputView;
import racingcar.view.TextInputView;
import racingcar.view.TextOutputView;

public final class AppConfig {

    public Controller controller() {
        return new Controller(inputView(), outputView(), racingCarService());
    }

    private InputView inputView() {
        return new TextInputView();
    }

    private OutputView outputView() {
        return new TextOutputView();
    }

    private RacingCarService racingCarService() {
        return new RacingCarServiceImpl();
    }
}
