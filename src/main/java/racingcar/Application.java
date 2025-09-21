package racingcar;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        try {
            InputManager inputManager = new InputManager();
            OutputManager outputManager = new OutputManager();

            List<String> carNames = inputManager.getCarNames();
            int numberOfRounds = inputManager.getNumberOfRounds();

            RacingGame game = new RacingGame(carNames);

            System.out.println("\n실행 결과");
            for (int i = 0; i < numberOfRounds; i++) {
                game.playRound();
                outputManager.printRoundResult(game.getCars());
            }

            outputManager.printWinners(game.getWinners());
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
            throw e;
        }
    }
}
