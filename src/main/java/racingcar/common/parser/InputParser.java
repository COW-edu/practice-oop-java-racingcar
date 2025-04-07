package racingcar.common.parser;

import racingcar.common.constant.GameConstants;

import java.util.Arrays;
import java.util.List;

import static racingcar.common.constant.ErrorMessages.*;

public class InputParser {

    public List<String> parseCarNames(String input) {
        try {
            return Arrays.stream(input.split(GameConstants.CAR_NAME_DELIMITER))
                    .toList();
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(INVALID_CAR_NAMES);
        }
    }

    public int parseTotalRound(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(INVALID_ROUND_INPUT);
        }
    }
}

