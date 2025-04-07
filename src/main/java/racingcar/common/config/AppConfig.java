package racingcar.common.config;

import racingcar.common.parser.InputParser;
import racingcar.controller.RacingGameController;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public final class AppConfig {

    private static final AppConfig INSTANCE = new AppConfig();
    private final RacingGameController racingGameController;

    private AppConfig() {
        this.racingGameController = new RacingGameController(
                inputView(),
                outputView(),
                parser()
        );
    }

    public static AppConfig getInstance() {
        return INSTANCE;
    }

    public RacingGameController getRacingGameController() {
        return racingGameController;
    }

    private InputView inputView() {
        return new InputView();
    }

    private OutputView outputView() {
        return new OutputView();
    }

    private InputParser parser() {
        return new InputParser();
    }
}
