package racingcar.config;


import racingcar.controller.RacingGameController;
import racingcar.service.RacingGameService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class AppConfig {

    public RacingGameController racingGameController() {
        return new RacingGameController(inputView(), outputView(), racingGameService());
    }

    private InputView inputView() {
        return new InputView();
    }

    private OutputView outputView() {
        return new OutputView();
    }

    private RacingGameService racingGameService() {
        return new RacingGameService();
    }
}