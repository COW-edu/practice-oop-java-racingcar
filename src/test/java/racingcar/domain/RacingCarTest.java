package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.domain.model.RacingCar;
import racingcar.domain.model.RacingMachine;

class RacingCarTest {
    RacingCar ddd = new RacingCar("ddd");
    RacingMachine racingMachine = new RacingMachine();

    @Test
    void validateName() {
        String name = ddd.getName();
        Assertions.assertThat(name).isEqualTo("ddd");
    }

    @Test
    void move() {

    }
}