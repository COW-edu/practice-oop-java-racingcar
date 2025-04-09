package racingcar.domain;

import racingcar.dto.RoundResultDto;
import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;
import racingcar.domain.strategy.MovementStrategy;
import racingcar.domain.strategy.RandomMovement;
import racingcar.view.View;
import java.util.Arrays;
import java.util.stream.Collectors;

public class RaceManager {
    private final View view;
    private final MovementStrategy movementStrategy;
    private Cars cars;

    public RaceManager(View view, MovementStrategy movementStrategy) {
        this.view = view;
        this.movementStrategy = movementStrategy;
    }

    public void start() {
        String[] carNames = view.readCarNames();
        this.cars = new Cars(Arrays.asList(carNames));

        int attempts = view.readAttempts();
        view.printRaceStart();

        for (int i = 0; i < attempts; i++) {
            executeRound();
        }
        announceWinners();
    }

    private void executeRound() {
        cars.moveAll(movementStrategy);
        RoundResultDto result = new RoundResultDto(
                cars.getRacers().stream()
                        .map(Car::toString)
                        .collect(Collectors.toList())
        );
        view.printRoundResult(result.formatResult());
    }

    private void announceWinners() {
        view.printWinners(cars.findWinnerNames());
    }
}