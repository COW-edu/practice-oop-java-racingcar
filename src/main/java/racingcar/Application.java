package racingcar;

import racingcar.domain.RaceManager;
import racingcar.view.ConsoleView;
import racingcar.view.View;

public class Application {
    public static void main(String[] args) {
        try {
            View view = new ConsoleView();
            RaceManager raceManager = new RaceManager(view);
            raceManager.start();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}