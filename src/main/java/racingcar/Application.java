package racingcar;

import racingcar.config.AppConfig;
import racingcar.controller.RacingGameController;
import racingcar.domain.strategy.RandomMoveStrategy;

public class Application {
    public static void main(String[] args) {
        AppConfig config = new AppConfig();
        RacingGameController controller = config.racingGameController();
        controller.run(new RandomMoveStrategy());
    }
}
