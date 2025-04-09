package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

import static racingcar.constants.ErrorMessage.*;

public class ConsoleView implements View {
    private static final String CAR_NAMES_DELIMITER = ",";
    private static final String INPUT_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_CHANCE = "시도할 회수는 몇회인가요?";
    private static final String OUTPUT_MESSAGE="\n실행 결과";
    private static final String OUTPUT_FINAL_WINNER="최종 우승자 : ";

    @Override
    public String[] readCarNames() {
        System.out.println(INPUT_NAME);
        String input = Console.readLine();
        validateCarNames(input);
        return input.split(CAR_NAMES_DELIMITER);
    }

    @Override
    public int readAttempts() {
        System.out.println(INPUT_CHANCE);
        String input = Console.readLine();
        return validateAndParseAttempts(input);
    }

    @Override
    public void printRaceStart() {
        System.out.println(OUTPUT_MESSAGE);
    }

    @Override
    public void printRoundResult(String roundResult) {
        System.out.println(roundResult);
        System.out.println();
    }

    @Override
    public void printWinners(List<String> winners) {
        System.out.print(OUTPUT_FINAL_WINNER);
        System.out.println(String.join(", ", winners));
    }

    private void validateCarNames(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException(NAME_ERROR.toString());
        }
        //중복 등 메서드 추가 예정
    }

    private int validateAndParseAttempts(String input) {
        try {
            int attempts = Integer.parseInt(input);
            if (attempts <= 0) {
                throw new IllegalArgumentException(CHANCE_NEGATIVE_ERROR.toString());
            }
            return attempts;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(CHANCE_TYPE_ERROR.toString());
        }
    }
}