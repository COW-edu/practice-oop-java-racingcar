package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RacingCarTest {


    @Test
    void validateName() {
        RacingCar ddd = new RacingCar("ddd");
        ddd.validateName();
        String name = ddd.getName();
        Assertions.assertThat(name).isEqualTo("ddd");
    }
}