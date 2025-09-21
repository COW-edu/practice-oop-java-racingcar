package racingcar;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.assertj.core.api.Assertions.*;

class CarTest {
    
    @Test
    @DisplayName("자동차 이름이 5자를 초과하면 예외가 발생한다")
    void validateName_TooLongName_ThrowsException() {
        assertThatThrownBy(() -> new Car("abcdef"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 5자 이하여야 합니다.");
    }
    
    @Test
    @DisplayName("자동차 이름이 비어있으면 예외가 발생한다")
    void validateName_EmptyName_ThrowsException() {
        assertThatThrownBy(() -> new Car(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 비어있을 수 없습니다.");
    }
    
    @Test
    @DisplayName("자동차 이름이 null이면 예외가 발생한다")
    void validateName_NullName_ThrowsException() {
        assertThatThrownBy(() -> new Car(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 비어있을 수 없습니다.");
    }
    
    @Test
    @DisplayName("자동차 이름이 공백만 있으면 예외가 발생한다")
    void validateName_BlankName_ThrowsException() {
        assertThatThrownBy(() -> new Car("   "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 비어있을 수 없습니다.");
    }
    
    @Test
    @DisplayName("유효한 자동차 이름으로 생성할 수 있다")
    void createCar_ValidName_Success() {
        Car car = new Car("pobi");
        
        assertThat(car.getName()).isEqualTo("pobi");
        assertThat(car.getPosition()).isEqualTo(0);
    }
    
    @Test
    @DisplayName("자동차 이름이 5자일 때 생성할 수 있다")
    void createCar_FiveCharacterName_Success() {
        Car car = new Car("abcde");
        
        assertThat(car.getName()).isEqualTo("abcde");
        assertThat(car.getPosition()).isEqualTo(0);
    }
    
    @Test
    @DisplayName("자동차의 초기 위치는 0이다")
    void getPosition_InitialPosition_IsZero() {
        Car car = new Car("pobi");
        
        assertThat(car.getPosition()).isEqualTo(0);
    }
    
    @Test
    @DisplayName("자동차의 초기 위치 문자열은 빈 문자열이다")
    void getPositionString_InitialPosition_IsEmpty() {
        Car car = new Car("pobi");
        
        assertThat(car.getPositionString()).isEqualTo("");
    }
}
