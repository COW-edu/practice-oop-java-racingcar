package racingcar;

import racingcar.domain.RaceManager;
import racingcar.domain.strategy.MovementStrategy;
import racingcar.domain.strategy.RandomMovement;
import racingcar.view.ConsoleView;
import racingcar.view.View;

public class Application {
    public static void main(String[] args) {
        try {
            View view = new ConsoleView();
            MovementStrategy strategy=new RandomMovement();
            RaceManager raceManager = new RaceManager(view,strategy);
            raceManager.start();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        // TODO: 프로그램 구현
    }
}
