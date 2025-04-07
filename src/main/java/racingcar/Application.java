package racingcar;

import racingcar.common.config.AppConfig;
import racingcar.controller.RacingGameController;

public class Application {

    public static void main(String[] args) {
        RacingGameController controller = AppConfig.getInstance().getRacingGameController();
        controller.run();
    }
}
