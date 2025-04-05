package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.domain.model.RacingCar;
import racingcar.domain.model.RacingMachine;
import racingcar.domain.rule.MoveStrategy;

class RacingCarTest {
    RacingCar ddd = new RacingCar("ddd");
    RacingMachine racingMachine = new RacingMachine();

    @Test
    void validateName() {
        ddd.validateName();
        String name = ddd.getName();
        Assertions.assertThat(name).isEqualTo("ddd");
    }

    @Test
    void move() {
        boolean moveable = racingMachine.isMoveable();
        if (moveable) {
            Assertions.assertThat(ddd.getWinning()).isEqualTo("-");
        } else {
            Assertions.assertThat(ddd.getWinning()).isEqualTo(null);
        }
    }
}