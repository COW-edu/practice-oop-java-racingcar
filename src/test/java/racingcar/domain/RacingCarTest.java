package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.domain.model.RacingCar;

class RacingCarTest {
    RacingCar ddd = new RacingCar("ddd");

    @Test
    void validateName() {
        String name = ddd.getName();
        Assertions.assertThat(name).isEqualTo("ddd");
    }

    @Test
    void move() {

    }
}