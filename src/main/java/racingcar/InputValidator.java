package racingcar;

import java.util.Arrays;
import java.util.List;

public class InputValidator {
    
    public static List<String> validateCarNames(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("자동차 이름을 입력해주세요.");
        }
        
        List<String> carNames = Arrays.asList(input.split(",", -1));
        for (String name : carNames) {
            String trimmedName = name.trim();
            validateCarName(trimmedName);
        }
        
        return carNames;
    }
    
    private static void validateCarName(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 비어있을 수 없습니다.");
        }
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
        }
    }
    
    public static int validateAttemptCount(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("시도할 회수를 입력해주세요.");
        }
        
        try {
            int count = Integer.parseInt(input.trim());
            if (count <= 0) {
                throw new IllegalArgumentException("시도할 회수는 1 이상이어야 합니다.");
            }
            return count;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도할 회수는 숫자여야 합니다.");
        }
    }
}
