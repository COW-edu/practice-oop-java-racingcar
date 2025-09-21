package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        try {
            List<String> carNames = getCarNames();
            int attemptCount = getAttemptCount();
            
            RacingGame game = new RacingGame(carNames);
            playGame(game, attemptCount);
            
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }
    
    private static List<String> getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        return InputValidator.validateCarNames(input);
    }
    
    private static int getAttemptCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        String input = Console.readLine();
        return InputValidator.validateAttemptCount(input);
    }
    
    private static void playGame(RacingGame game, int attemptCount) {
        System.out.println();
        System.out.println("실행 결과");
        
        for (int i = 0; i < attemptCount; i++) {
            game.playRound();
            game.printRoundResult();
        }
        
        game.printWinners();
    }
}
