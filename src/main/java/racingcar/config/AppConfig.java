package racingcar.config;


import racingcar.controller.RacingGameController;
import racingcar.service.RacingGameService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class AppConfig {

    public RacingGameController racingGameController() {
        return new RacingGameController(inputView(), outputView(), racingGameService());
    }

    public InputView inputView() {
        return new InputView();
    }

    public OutputView outputView() {
        return new OutputView();
    }

    public RacingGameService racingGameService() {
        return new RacingGameService();
    }
}