package racingcar;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import java.util.List;
import static org.assertj.core.api.Assertions.*;

class InputValidatorTest {
    
    @Test
    @DisplayName("유효한 자동차 이름들을 검증할 수 있다")
    void validateCarNames_ValidNames_Success() {
        List<String> result = InputValidator.validateCarNames("pobi,woni,jun");
        
        assertThat(result).containsExactly("pobi", "woni", "jun");
    }
    
    @Test
    @DisplayName("자동차 이름이 비어있으면 예외가 발생한다")
    void validateCarNames_EmptyInput_ThrowsException() {
        assertThatThrownBy(() -> InputValidator.validateCarNames(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름을 입력해주세요.");
    }
    
    @Test
    @DisplayName("자동차 이름이 null이면 예외가 발생한다")
    void validateCarNames_NullInput_ThrowsException() {
        assertThatThrownBy(() -> InputValidator.validateCarNames(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름을 입력해주세요.");
    }
    
    @Test
    @DisplayName("자동차 이름 중 하나가 5자를 초과하면 예외가 발생한다")
    void validateCarNames_TooLongName_ThrowsException() {
        assertThatThrownBy(() -> InputValidator.validateCarNames("pobi,abcdef"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 5자 이하여야 합니다.");
    }
    
    @Test
    @DisplayName("자동차 이름 중 하나가 비어있으면 예외가 발생한다")
    void validateCarNames_EmptyName_ThrowsException() {
        assertThatThrownBy(() -> InputValidator.validateCarNames("pobi,,"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 비어있을 수 없습니다.");
    }
    
    @Test
    @DisplayName("유효한 시도 횟수를 검증할 수 있다")
    void validateAttemptCount_ValidCount_Success() {
        int result = InputValidator.validateAttemptCount("5");
        
        assertThat(result).isEqualTo(5);
    }
    
    @Test
    @DisplayName("시도 횟수가 비어있으면 예외가 발생한다")
    void validateAttemptCount_EmptyInput_ThrowsException() {
        assertThatThrownBy(() -> InputValidator.validateAttemptCount(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도할 회수를 입력해주세요.");
    }
    
    @Test
    @DisplayName("시도 횟수가 null이면 예외가 발생한다")
    void validateAttemptCount_NullInput_ThrowsException() {
        assertThatThrownBy(() -> InputValidator.validateAttemptCount(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도할 회수를 입력해주세요.");
    }
    
    @Test
    @DisplayName("시도 횟수가 숫자가 아니면 예외가 발생한다")
    void validateAttemptCount_NotNumber_ThrowsException() {
        assertThatThrownBy(() -> InputValidator.validateAttemptCount("abc"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도할 회수는 숫자여야 합니다.");
    }
    
    @Test
    @DisplayName("시도 횟수가 0 이하면 예외가 발생한다")
    void validateAttemptCount_ZeroOrNegative_ThrowsException() {
        assertThatThrownBy(() -> InputValidator.validateAttemptCount("0"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도할 회수는 1 이상이어야 합니다.");
        
        assertThatThrownBy(() -> InputValidator.validateAttemptCount("-1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도할 회수는 1 이상이어야 합니다.");
    }
}
