package racingcar.view;

import racingcar.domain.Car;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    private static final String WINNER_ANNOUNCEMENT_PREFIX = "최종 우승자 : ";
    private static final String NAME_POSITION_SEPARATOR = " : ";
    private static final String POSITION_SYMBOL = "-";

    public void printCars(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + NAME_POSITION_SEPARATOR + POSITION_SYMBOL.repeat(car.getPosition()));
        }
        System.out.println();
    }

    public void printWinners(List<Car> winners) {
        String winnerNames = winners.stream()
                .map(Car::getName)
                .collect(Collectors.joining(","));
        System.out.println(WINNER_ANNOUNCEMENT_PREFIX + winnerNames);
    }
}