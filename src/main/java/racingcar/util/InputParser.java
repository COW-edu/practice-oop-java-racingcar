package racingcar.util;

import java.util.Arrays;
import java.util.List;

public class InputParser {

    public static List<String> parseCarNames(String input) {
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .filter(name -> !name.isBlank())
                .toList();
    }

    public static int parseTryCount(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_TRY_COUNT);
        }
    }
}
