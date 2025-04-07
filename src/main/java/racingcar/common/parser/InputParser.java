package racingcar.common.parser;

import java.util.Arrays;
import java.util.List;

public class InputParser {

    public List<String> parseCarNames(String input) {
        return Arrays.asList(input.split(","));
    }

    public int parseTotalRound(String input) {
        return Integer.parseInt(input);
    }
}
